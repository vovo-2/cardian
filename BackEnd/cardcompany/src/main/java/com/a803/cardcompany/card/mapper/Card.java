package com.a803.cardcompany.card.mapper;

import com.a803.cardcompany.card.BenefitCode;
import com.a803.cardcompany.card.CardType;
import com.a803.cardcompany.card.dto.CardDto;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.transaction.mapper.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
* 작성자 : 정여민
* 작성 일시 : 2024.01.25
*
 */


@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    // 카드사 이름
    @Column(name = "cardcompany")
    private String cardCompany;

    // 카드 종류 - 신용, 체크
    @Enumerated(EnumType.STRING)
    private CardType type;

    // 카드 이름
    @Column(nullable = false, length = 50)
    private String name;

    // 카드 번호 16자리
    private String number;

    // 카드 이미지 - url
    @Column(nullable = false, length = 400)
    private String image;

    // 실적 기준
    @Column(nullable = false)
    private int goal;

    // 만료일자
    @Column(name = "expiredate", nullable = false)
    private LocalDateTime expireDate;

    // 연회비
    @Column(name = "annualfee")
    private int annualFee;

    // 혜택 코드
    @Enumerated(EnumType.STRING)
    private BenefitCode benefitCode;

//    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
//    private List<Transaction> transactions = new ArrayList<>();

    @Builder
    public Card(Integer id, Member member, String cardCompany, CardType type, String name, String number,
                String image, int goal, LocalDateTime expireDate, int annualFee, BenefitCode benefitCode){
        this.id = id;
        this.member = member;
        this.cardCompany = cardCompany;
        this.type = type;
        this.name = name;
        this.number = number;
        this.image = image;
        this.goal = goal;
        this.expireDate = expireDate;
        this.annualFee = annualFee;
        this.benefitCode = benefitCode;
    }


    // Entity to dto
    public CardDto toDto(){
        return CardDto.builder()
                .id(id)
                .cardCompany(cardCompany)
                .goal(goal)
                .name(name)
                .member(member)
                .image(image)
                .type(type)
                .number(number)
                .build();
    }

}
