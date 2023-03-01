package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Post;
import toy.blog.repository.PostRepository;
import toy.blog.service.PostService;

import java.util.List;

@Service(value = "postService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional(readOnly = false)
    public Long post(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public Post findOne(Long id) {
        return null;
    }

    @Override
    public List<Post> fineAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public Post updatePost(Long id) {
        Post findPost = postRepository.findOne(id);
        findPost.setTitle("udpateTitle");
        findPost.setContent("updateContent");
        return findPost;
    }
}
