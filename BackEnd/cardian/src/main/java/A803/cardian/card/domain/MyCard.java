package A803.cardian.card.domain;

import A803.cardian.associate.domain.Associate;
import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/*
*   업데이트 : 2024.02.04
*   내용 : updateDate를 MyCard가 아닌, Member로 변경
* 
* */
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
    private String number;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate expireDate;

    @OneToMany(mappedBy = "myCard", fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();


    @Builder
    public MyCard(Member member,
                  Card card,
                  String number,
                  LocalDate expireDate){
        this.member = member;
        this.card = card;
        this.number = number;
        this.expireDate = expireDate;
    }
}
