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
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<PostHashTag> postHashTags = new ArrayList<>();

    private UseStatus useStatus;
    private LocalDateTime registDate;

    public static class Builder {

        private Member member;
        private String title;
        private String content;

        public Builder(Member member, String title) {
            this.member = member;
            this.title = title;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }

    public Post(Builder builder) {
        this.member = builder.member;
        this.title = builder.title;
        this.content = builder.content;
        this.useStatus = UseStatus.USED;
        this.registDate = LocalDateTime.now();
    }

    // 게시글 삭제
    public void delete() {
        this.useStatus = UseStatus.DELETE;
    }
}