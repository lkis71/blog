package toy.blog.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.entity.Comment;
import toy.blog.repository.CommentRepository;
import toy.blog.service.CommentService;

@Service(value = "commentService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public Long save(Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
    }

    @Override
    public Comment update(Long id, String content) {
        Comment findComment = commentRepository.findOne(id);
        findComment.setContent(content);
        return findComment;
    }
}
