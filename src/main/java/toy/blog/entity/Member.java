package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String memberId;

    private String password;

    private String contact;

    public static Member createUser(String memberId, String password) {

        Member member = new Member();
        member.memberId = memberId;
        member.password = password;

        return member;
    }
}
