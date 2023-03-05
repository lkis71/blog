package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Post;
import toy.blog.entity.PostHashTag;
import toy.blog.repository.PostHashTagRepository;
import toy.blog.repository.PostRepository;
import toy.blog.service.PostService;

import java.util.List;

@Service(value = "postService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostHashTagRepository postHashTagRepository;

    @Override
    @Transactional(readOnly = false)
    public Long save(Post post) {
        postRepository.save(post);

        return post.getId();
    }

    @Override
    public Post findOne(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public List<Post> fineAll() {
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Post updatePost(Long id, String title, String content) {
        Post findPost = postRepository.findOne(id);
        findPost.setTitle(title);
        findPost.setContent(content);
        return findPost;
    }

    @Override
    @Transactional(readOnly = false)
    public void deletePost(Long id) {
        Post findPost = postRepository.findOne(id);
        findPost.delete();

        List<PostHashTag> postHashTags = postHashTagRepository.findByPostId(id);

        for (PostHashTag postHashTag : postHashTags) {
            postHashTagRepository.remove(postHashTag);
        }
    }
}
