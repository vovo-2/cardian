package A803.cardian.member.domain;

import A803.cardian.card.domain.MyCard;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false,length = 400)
    private String refreshToken;

    @Column(nullable = false,length = 400)
    private String tokenPassword;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
