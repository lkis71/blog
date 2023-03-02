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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Member member;

    @Setter
    private String title;

    @Setter
    private String content;

    @OneToMany(mappedBy = "post")
    private List<PostHashTag> postHashTags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private String useAt;

    private LocalDateTime registDate;

    // 생성메서드
    public static Post createPost(Member member, String title, String content) {

        Post post = new Post();
        post.member = member;
        post.title = title;
        post.content = content;
        post.useAt = "Y";
        post.registDate = LocalDateTime.now();

        return post;
    }

    // 게시글 삭제
    public void delete() {
        this.useAt = "N";
    }
}
