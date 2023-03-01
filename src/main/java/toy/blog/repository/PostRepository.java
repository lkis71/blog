package toy.blog.repository;

import toy.blog.entity.Post;

import java.util.List;

public interface PostRepository {

    public void save(Post post);

    public Post findOne(Long id);

    public List<Post> findAll();
}
