package toy.blog.post.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class HashTag {

    @Id @GeneratedValue
    @Column(name = "hash_tag_id")
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "hashTag")
    private Set<PostHashTag> postHashTags = new HashSet<>();

    public static HashTag createHashTag(String name) {

        HashTag hashTag = new HashTag();
        hashTag.name = name;

        return hashTag;
    }

    public boolean isEmpty() {
        if (getId() == null) {
            return true;
        } else {
            return false;
        }
    }
}
