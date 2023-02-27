package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashTag {

    @Id @GeneratedValue
    @Column(name = "hash_tag_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hashTag")
    private List<PostHashTag> postHashTags = new ArrayList<>();
}
