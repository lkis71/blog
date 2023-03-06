package toy.blog.post.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.post.entity.Post;
import toy.blog.post.entity.PostHashTag;
import toy.blog.post.repository.PostHashTagRepository;
import toy.blog.post.repository.PostRepository;
import toy.blog.post.service.PostService;

import java.util.List;

@Service(value = "postService")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostHashTagRepository postHashTagRepository;

    @Override
    @Transactional
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
    @Transactional
    public Post updatePost(Long id, String title, String content) {
        Post findPost = postRepository.findOne(id);
        findPost.setTitle(title);
        findPost.setContent(content);
        return findPost;
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        Post findPost = postRepository.findOne(id);
        findPost.delete();

        List<PostHashTag> postHashTags = postHashTagRepository.findByPostId(id);

        for (PostHashTag postHashTag : postHashTags) {
            postHashTagRepository.remove(postHashTag);
        }
    }
}
