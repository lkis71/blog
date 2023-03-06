package toy.blog.post.repository;

import toy.blog.post.entity.Comment;

import java.util.List;

public interface CommentRepository {

    public void save(Comment comment);

    public Comment findOne(Long id);

    public List<Comment> findByPostId(Long postId);
}
