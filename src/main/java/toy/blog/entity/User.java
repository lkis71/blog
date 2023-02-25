package toy.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name = "seq")
    private Long id;

    private String userId;

    private String password;

    private String contact;
}
