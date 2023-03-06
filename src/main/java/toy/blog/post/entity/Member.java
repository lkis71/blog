package toy.blog.post.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "member_id", nullable = false, unique = true)
    private String memberId;

    private String password;

    private String contact;

    public static Member createMember(String memberId, String password) {

        Member member = new Member();
        member.memberId = memberId;
        member.password = password;

        return member;
    }
}
