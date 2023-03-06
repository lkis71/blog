package toy.blog.post.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @Setter
    private String content;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Enumerated(EnumType.STRING)
    private UseStatus useStatus;

    private LocalDateTime registDate;

    public static class Builder {

        private Member member;
        private Post post;
        private String content;

        public Builder(Member member, Post post) {
            this.member = member;
            this.post = post;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Comment build() {
            return new Comment(this);
        }
    }

    public Comment(Builder builder) {
        this.member = builder.member;
        this.post = builder.post;
        this.content = builder.content;
        this.useStatus = UseStatus.USED;
        this.registDate = LocalDateTime.now();
    }
}
