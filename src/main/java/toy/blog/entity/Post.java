package toy.blog.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue
    @Column(name = "postId")
    private Long id;

    private String userId;
    private String title;
    private String content;
    private LocalDateTime registDate;
}
