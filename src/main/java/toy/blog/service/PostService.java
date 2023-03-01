package toy.blog.service;

import toy.blog.entity.Post;

import java.util.List;

public interface PostService {

    public Long post(Post post);

    public Post findOne(Long id);

    public List<Post> fineAll();

    public Post updatePost(Long id);
}
