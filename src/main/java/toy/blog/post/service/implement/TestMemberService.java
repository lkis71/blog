package toy.blog.post.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toy.blog.post.entity.Member;

import javax.persistence.EntityManager;

@Service
@Transactional
@RequiredArgsConstructor
public class TestMemberService {

    private final EntityManager em;

    public void join(Member member) {
        em.persist(member);
    }
}
