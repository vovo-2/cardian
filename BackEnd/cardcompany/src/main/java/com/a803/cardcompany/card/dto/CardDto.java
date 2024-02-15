package com.a803.cardcompany.card.dto;

import com.a803.cardcompany.card.BenefitCode;
import com.a803.cardcompany.card.CardType;
import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.transaction.mapper.Transaction;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CardDto {

    private Integer id;

    private Member member;

    private String cardCompany;

    // 카드 종류 - 신용, 체크
    private CardType type;

    // 카드 이름
    private String name;

    // 카드 번호 16자리
    private String number;

    // 카드 이미지 - url
    private String image;

    // 실적 기준
    private int goal;

    // 만료일자
    private LocalDate expireDate;

    // 연회비
    private int annualFee;

    // 혜택 코드
    private BenefitCode benefitCode;


    // dto -> entity
//    public Card toEntity(){
//        return Card.builder()
//                .member(new Member())
//                .cardCompany("신한카드")
//                .type(CardType.credit)
//                .name("신한S-choice")
//                .number("1234567812345678")
//                .image("http://google.com.png")
//                .goal(10000)
//                .expireDate(LocalDateTime.now())
//                .annualFee(70000)
//                .benefitCode("BC01")
//                .build();
//    }


    // dto -> Entity
    public Card toEntity(){
        return Card.builder()
                .member(member)
                .cardCompany(cardCompany)
                .type(type)
                .name(name)
                .number(number)
                .image(image)
                .goal(goal)
                .expireDate(expireDate)
                .annualFee(annualFee)
                .benefitCode(benefitCode)
                .build();
    }

}
