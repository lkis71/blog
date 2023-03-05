package toy.blog.service.implement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Comment;
import toy.blog.entity.Member;
import toy.blog.entity.Post;
import toy.blog.repository.CommentRepository;
import toy.blog.repository.PostRepository;
import toy.blog.service.CommentService;
import toy.blog.service.PostService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class CommentServiceImplTest {

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
        List<Comment> findComments = commentRepository.findAllByPostId(postId);
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
        boolean isSave = false;

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
        Member member = new Member.Builder("testId", "1234")
                .setContact("010-1234-1234")
                .build();
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