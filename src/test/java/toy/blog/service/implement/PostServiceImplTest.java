package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Post;
import toy.blog.entity.User;
import toy.blog.repository.PostRepository;
import toy.blog.service.PostService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
class PostServiceImplTest {

    PostService postService;
    PostRepository postRepository;

    @Test
    public void 포스팅() throws Exception {
        //given
        User user = User.createUser("testId", "1234");
        Post post = Post.createPost(user, "제목", "내용");

        //when
        Long postId = postService.post(post);

        //then
        Post finePost = postRepository.findOne(postId);
        assertThat(postId).isEqualTo(finePost.getId());
    }
}