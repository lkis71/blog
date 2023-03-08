package toy.blog.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.post.entity.*;
import toy.blog.post.repository.HashTagRepository;
import toy.blog.post.repository.PostHashTagRepository;
import toy.blog.post.repository.PostRepository;
import toy.blog.post.service.HashTagService;
import toy.blog.post.service.PostHashTagService;
import toy.blog.post.service.PostService;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostServiceImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    HashTagService hashTagService;

    @Autowired
    HashTagRepository hashTagRepository;

    @Autowired
    PostHashTagService postHashTagService;

    @Autowired
    PostHashTagRepository postHashTagRepository;

    @Test
    public void 게시글_등록() throws Exception {
        //given
        Member member = getMember();
        Post post1 = getPost(member);
        Post post2 = getPost(member);

        //when
        Long postId1 = postService.save(post1);
        Long postId2 = postService.save(post2);

        Post findPost1 = postRepository.findOne(postId1);
        Post findPost2 = postRepository.findOne(postId2);

        //then
        assertThat(postId1).isEqualTo(findPost1.getId());
        assertThat(postId2).isEqualTo(findPost2.getId());
    }

    @Test
    public void 게시글_수정() throws Exception {
        //given
        Member member = getMember();
        Post post = getPost(member);

        //when
        Long id = postService.save(post);
        Post findPost = postService.findOne(id);

        String title = findPost.getTitle();
        String content = findPost.getContent();

        Post updatePost = postService.updatePost(id, "제목2", "내용2");

        //then
        assertThat(title).isNotEqualTo(updatePost.getTitle());
        assertThat(content).isNotEqualTo(updatePost.getContent());
    }

    @Test
    public void 게시글_삭제() throws Exception {
        //given
        Member member = getMember();

        Post post = getPost(member);
        Long id = postService.save(post);

        HashTag hashTag = HashTag.createHashTag("스프링");
        hashTagService.save(hashTag);

        PostHashTag postHashTag = PostHashTag.createPostHashTag(post, hashTag);
        postHashTagService.save(postHashTag);

        //when
        postService.deletePost(id);

        //then
        assertThat(post.getUseStatus()).isEqualTo(UseStatus.DELETE);
    }

    @Test
    public void 해시태그_등록() throws Exception {
        //given
        Member member = getMember();
        
        Post post = getPost(member);
        Long postId = postService.save(post);

        HashTag hashTag = HashTag.createHashTag("스프링");
        String compareName = hashTag.getName();

        //when
        hashTagService.save(hashTag);

        PostHashTag postHashTag = PostHashTag.createPostHashTag(post, hashTag);
        postHashTagService.save(postHashTag);

        HashTag findHashTag = hashTagRepository.findOne(hashTag.getId());

        //then
        assertThat(compareName).isEqualTo(findHashTag.getName());
    }
    
    @Test
    public void 해시태그_삭제() throws Exception {
        //given
        Member member = getMember();

        Post post = getPost(member);
        Long postId = postService.save(post);

        HashTag hashTag = HashTag.createHashTag("스프링");
        hashTagService.save(hashTag);

        //when
        PostHashTag postHashTag = PostHashTag.createPostHashTag(post, hashTag);
        postHashTagService.save(postHashTag);

        postHashTagRepository.remove(postHashTag);
        List<PostHashTag> findPostHashTags = postHashTagRepository.findByPostId(postId);

        //then
        assertThat(findPostHashTags).isEmpty();
    }

    private Member getMember() {
        Member member = Member.createMember("testId", "1234");
        em.persist(member);
        return member;
    }

    private Post getPost(Member member) {

        Post post = new Post.Builder(member, "제목")
                .setContent("내용")
                .build();
        return post;
    }
}