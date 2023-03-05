package toy.blog.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "member_id", nullable = false, unique = true)
    private String memberId;

    private String password;

    private String contact;

    public static class Builder {

        private String memberId;
        private String password;
        private String contact;

        public Builder(String memberId, String password) {
            this.memberId = memberId;
            this.password = password;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }

    public Member(Builder builder) {
        this.memberId = builder.memberId;
        this.password = builder.password;
        this.contact = builder.contact;
    }
}
