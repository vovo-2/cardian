package com.a803.cardcompany.transaction.dto;

import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.transaction.mapper.Transaction;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TransactionDto {

    private Integer id;

    private Card card;

    // 거래 번호
    private int number;

    // 거래 일자 (년월일)
    private LocalDate day;

    // 거래 일자 (년월일시분초)
    private LocalDateTime date;

    // 사용처
    private String store;

    // 금액
    private int price;

    // 상태 - 승인, 취소
    private boolean status;

    // 할인여부
    private boolean discount;




    // dto -> Entity
    public Transaction toEntity(){
        return Transaction.builder()
                .card(card)
                .number(number)
                .day(day)
                .date(date)
                .store(store)
                .price(price)
                .status(status)
                .discount(discount)
                .build();
    }


}
