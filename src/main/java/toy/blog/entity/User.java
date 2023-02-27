package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue
    @Column(name = "user_seq")
    private Long id;

    private String userId;

    private String password;

    private String contact;

    public static User createUser(String userId, String password) {

        User user = new User();
        user.userId = userId;
        user.password = password;

        return user;
    }
}
