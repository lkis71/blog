package toy.blog.post.repository.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toy.blog.post.entity.HashTag;
import toy.blog.post.repository.HashTagRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class HashTagRepositoryImpl implements HashTagRepository {

    private final EntityManager em;

    @Override
    public void save(HashTag hashTag) {
        em.persist(hashTag);
    }

    @Override
    public HashTag findOne(Long id) {
        return em.find(HashTag.class, id);
    }

    @Override
    public HashTag findByName(String name) {
        List<HashTag> hashTags = em.createQuery(
                                "select ht " +
                                        "from HashTag ht " +
                                        "where ht.name = :name", HashTag.class)
                .setParameter("name", name)
                .getResultList();

        return hashTags.stream().findAny().orElseGet(HashTag::new);
    }
}
