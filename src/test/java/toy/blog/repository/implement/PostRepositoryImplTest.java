package toy.blog.repository.implement;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Post;
import toy.blog.entity.User;
import toy.blog.repository.PostRepository;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class PostRepositoryImplTest {

    EntityManager em;
    PostRepository postRepository;

    @Test
    public void save() throws Exception {
        //given
        User user = User.createUser("test", "1234");
        Post post = Post.createPost(user, "타이틀", "내용");

        //when
        postRepository.save(post);

        //then
    }
}