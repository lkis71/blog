package toy.blog.post.repository;

import toy.blog.post.entity.Post;

import java.util.List;

public interface PostRepository {

    public void save(Post post);

    public Post findOne(Long id);

    public List<Post> findAll();
}
