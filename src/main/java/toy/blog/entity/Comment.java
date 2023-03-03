package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private String useAt;

    private LocalDateTime registDate;

    public static Comment createComment(Member member, Post post, String content) {
        Comment comment = new Comment();
        comment.member = member;
        comment.content = content;
        comment.post = post;
        comment.useAt = "Y";
        comment.registDate = LocalDateTime.now();
        return comment;
    }
}
