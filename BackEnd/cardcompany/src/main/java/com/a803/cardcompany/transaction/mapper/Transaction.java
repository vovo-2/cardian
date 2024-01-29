package com.a803.cardcompany.transaction.mapper;


import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.transaction.dto.TransactionDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 *  작성자 : 정여민
 *  작성 일시 : 2024.01.25
 *
 *
 *
 *
 */

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 아무런 매개변수가 없는 생성자를 생성하되 다른 패키지에 소속된 클래스는 접근을 불허한다
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Card card;

    // 거래 번호
    @Column(nullable = false)
    private int number;

    // 거래 일자 (년월일)
    @Column(nullable = false)
    private LocalDate day;

    // 거래 일자 (년월일시분초)
    @Column(nullable = false)
    private LocalDateTime date;

    // 사용처
    @Column(nullable = false)
    private String store;

    // 금액
    @Column(nullable = false)
    private int price;

    // 상태 - 승인, 취소
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean status;

    // 할인여부
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean discount;

    @Builder
    public Transaction(Integer id, Card card, int number, LocalDate day, LocalDateTime date,
                       String store, int price, boolean status, boolean discount){
        this.id = id;
        this.card = card;
        this.number = number;
        this.day = day;
        this.date = date;
        this.price = price;
        this.store = store;
        this.status = status;
        this.discount = discount;
    }

    public TransactionDto toDto(){
        return TransactionDto.builder()
                .id(id)
                .card(card)
                .number(number)
                .day(day)
                .date(date)
                .price(price)
                .store(store)
                .status(status)
                .discount(discount)
                .build();
    }


}
