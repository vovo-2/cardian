package com.a803.cardcompany.transaction.method;

import com.a803.cardcompany.transaction.dto.TransactionDto;

import java.util.Comparator;

/*
 * 작성자 : 정여민
 * 작성일시 : 2024.02.02
 * 업데이트 : 2024.02.02
 * 내용 : 거래 내역 시간순 정렬을 위한 메서드
 */
public class TransactionComparator implements Comparator<TransactionDto> {


    @Override
    public int compare(TransactionDto t1, TransactionDto t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}
