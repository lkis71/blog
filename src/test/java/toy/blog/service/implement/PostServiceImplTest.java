package toy.blog.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Post;
import toy.blog.entity.Member;
import toy.blog.repository.PostRepository;
import toy.blog.service.PostService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class PostServiceImplTest {

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    public void 게시글_등록() throws Exception {
        //given
        Post post = getPost();

        //when
        Long postId = postService.insert(post);

        //then
        Post finePost = postRepository.findOne(postId);
        assertThat(postId).isEqualTo(finePost.getId());
    }

    @Test
    public void 게시글_수정() throws Exception {
        //given
        Post post = getPost();

        //when
        Long id = postService.insert(post);
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
        Post post = getPost();

        //when
        Long id = postService.insert(post);
        postService.deletePost(id);

        //then
        assertThat(post.getUseAt()).isEqualTo("N");
    }

    private Post getPost() {
        Member member = Member.createMember("testId", "1234");
        Post post = Post.createPost(member, "제목", "내용");
        return post;
    }
}