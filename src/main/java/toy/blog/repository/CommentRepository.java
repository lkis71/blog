package toy.blog.repository;

import toy.blog.entity.Comment;

import java.util.List;

public interface CommentRepository {

    public void save(Comment comment);

    public Comment findOne(Long id);
}
