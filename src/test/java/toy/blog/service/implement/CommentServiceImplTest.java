package toy.blog.service.implement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Comment;
import toy.blog.entity.Member;
import toy.blog.entity.Post;
import toy.blog.repository.CommentRepository;
import toy.blog.repository.PostRepository;
import toy.blog.service.CommentService;
import toy.blog.service.PostService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

        Member member = Member.createMember("testId", "1234");

        Post post = Post.createPost(member, "제목1", "내용1");
        Long postId = postService.insert(post);

        Comment comment = Comment.createComment(member, post, "좋은 컨텐츠였어요!");
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

        Member member = Member.createMember("testId", "1234");

        Post post = Post.createPost(member, "제목1", "내용1");
        Long postId = postService.insert(post);

        Comment comment = Comment.createComment(member, post, "좋은 컨텐츠였어요!");
        Long commentId = commentService.save(comment);

        String content = comment.getContent();

        //when
        Comment updateComment = commentService.update(commentId, "나쁜 컨텐츠였어요!");

        //then
        assertThat(content).isNotEqualTo(updateComment.getContent());
    }
}