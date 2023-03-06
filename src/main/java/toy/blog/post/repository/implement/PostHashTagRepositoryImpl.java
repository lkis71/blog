package toy.blog.post.repository.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.blog.post.entity.PostHashTag;
import toy.blog.post.repository.PostHashTagRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostHashTagRepositoryImpl implements PostHashTagRepository {

    private final EntityManager em;

    @Override
    public void save(PostHashTag postHashTag) {
        em.persist(postHashTag);
    }

    @Override
    public List<PostHashTag> findByPostId(Long postId) {
        return em.createQuery(
                "select pht " +
                        "from PostHashTag pht " +
                        "where pht.post.id = :postId", PostHashTag.class)
                .setParameter("postId", postId)
                .getResultList();
    }

    @Override
    public void remove(PostHashTag postHashTag) {
        em.remove(postHashTag);
    }
}
