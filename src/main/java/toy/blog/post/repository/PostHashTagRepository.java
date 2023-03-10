package toy.blog.post.repository;

import toy.blog.post.entity.PostHashTag;

import java.util.List;

public interface PostHashTagRepository {

    public void save(PostHashTag postHashTag);

    public List<PostHashTag> findByPostId(Long postId);

    public void remove(PostHashTag postHashTag);
}
