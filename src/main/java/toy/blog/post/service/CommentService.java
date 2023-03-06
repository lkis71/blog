package toy.blog.post.service;

import toy.blog.post.entity.Comment;

public interface CommentService {

    public Long save(Comment comment);

    public Comment update(Long id, String content);
}
