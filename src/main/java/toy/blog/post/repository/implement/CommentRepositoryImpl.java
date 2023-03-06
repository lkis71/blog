package toy.blog.post.repository.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.blog.post.entity.Comment;
import toy.blog.post.repository.CommentRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final EntityManager em;

    @Override
    public void save(Comment comment) {
        em.persist(comment);
    }

    @Override
    public Comment findOne(Long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return em.createQuery(
                "select c " +
                        "from Comment c " +
                        "where c.post.id = :postId", Comment.class)
                .setParameter("postId", postId)
                .getResultList();
    }
}
