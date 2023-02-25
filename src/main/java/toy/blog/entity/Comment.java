package toy.blog.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "commonId")
    private Long id;

    private String userId;
    private String content;
    private LocalDateTime registDate;
}
