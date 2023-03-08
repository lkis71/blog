package toy.blog.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.post.entity.Comment;
import toy.blog.post.entity.Member;
import toy.blog.post.entity.Post;
import toy.blog.post.repository.CommentRepository;
import toy.blog.post.repository.PostRepository;
import toy.blog.post.service.CommentService;
import toy.blog.post.service.PostService;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CommentServiceImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostService postService;

    @Autowired
    PostRepository postRepository;

    @Test
    public void 댓글_등록() throws Exception {
        //given
        boolean isSave = false;

        Member member = getMember();

        Post post = getPost(member);
        Long postId = postService.save(post);

        Comment comment = getComment(member, post);
        Long commentId = commentService.save(comment);

        //when
        List<Comment> findComments = commentRepository.findByPostId(postId);
        for (Comment findComment : findComments) {
            if (findComment.getId() == commentId) {
                isSave = true;
            }
        }

        //then
        assertThat(isSave).isTrue();
    }

    @Test
    public void 댓글_수정() throws Exception {
        //given
        Member member = getMember();

        Post post = getPost(member);
        Long postId = postService.save(post);

        Comment comment = getComment(member, post);
        Long commentId = commentService.save(comment);

        String content = comment.getContent();

        //when
        Comment updateComment = commentService.update(commentId, "나쁜 컨텐츠였어요!");

        //then
        assertThat(content).isNotEqualTo(updateComment.getContent());
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

    private Comment getComment(Member member, Post post) {
        Comment comment = new Comment.Builder(member, post)
                .setContent("좋은 컨텐츠였어요!")
                .build();
        return comment;
    }
}