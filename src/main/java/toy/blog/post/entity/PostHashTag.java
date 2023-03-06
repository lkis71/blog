package toy.blog.post.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostHashTag {

    @Id @GeneratedValue
    @Column(name = "post_hash_tag_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "hash_tag_id")
    private HashTag hashTag;

    public static PostHashTag createPostHashTag(Post post, HashTag hashTag) {

        PostHashTag postHashTag = new PostHashTag();
        postHashTag.post = post;
        postHashTag.hashTag = hashTag;

        return postHashTag;
    }
}
