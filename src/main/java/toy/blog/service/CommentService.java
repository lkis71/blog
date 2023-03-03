package toy.blog.service;

import toy.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    public Long save(Comment comment);

    public Comment update(Long id, String content);
}
