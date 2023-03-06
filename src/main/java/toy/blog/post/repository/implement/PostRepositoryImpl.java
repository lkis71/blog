package toy.blog.post.repository.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.blog.post.entity.Post;
import toy.blog.post.repository.PostRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final EntityManager em;

    @Override
    public void save(Post post) {
        em.persist(post);
    }

    @Override
    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery(
                "select p " +
                        "from Post p " +
                        "join fetch Member m", Post.class)
                .getResultList();
    }
}
