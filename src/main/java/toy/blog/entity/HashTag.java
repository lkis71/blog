package toy.blog.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class HashTag {

    @Id @GeneratedValue
    @Column(name = "hashTagId")
    private Long id;

    private String name;
}
