package A803.cardian.card.domain;

import A803.cardian.associate.domain.Associate;
import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mycard_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
//    @Column(nullable = false)
//    private Integer memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date updateDate;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Date expireDate;

    @OneToMany(mappedBy = "myCard", fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();


    @Builder
    public MyCard(Member member,
                  Card card,
                  Date updateDate,
                  String number,
                  Date expireDate){
        this.member = member;
        this.card = card;
        this.updateDate = updateDate;
        this.number = number;
        this.expireDate = expireDate;
    }
}
