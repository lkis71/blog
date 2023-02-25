package toy.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostHashTag {

    @Id @GeneratedValue
    @Column(name = "postHashTagId")
    private Long id;

    private Long postId;
    private Long hashTagId;
}
