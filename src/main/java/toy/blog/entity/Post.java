package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;

    @Setter
    private String title;

    @Setter
    private String content;

    @OneToMany(mappedBy = "post")
    private List<PostHashTag> postHashTags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private LocalDateTime registDate;

    public static Post createPost(User user, String title, String content) {

        Post post = new Post();
        post.user = user;
        post.title = title;
        post.content = content;

        return post;
    }
}
