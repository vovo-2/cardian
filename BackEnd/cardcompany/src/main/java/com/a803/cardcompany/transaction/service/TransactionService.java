package com.a803.cardcompany.transaction.service;

import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.card.mapper.CardRepository;
import com.a803.cardcompany.transaction.dto.TransactionDto;
import com.a803.cardcompany.transaction.mapper.Transaction;
import com.a803.cardcompany.transaction.mapper.TransactionRepository;
import com.a803.cardcompany.transaction.method.TransactionComparator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final CardRepository cardRepository;


    //CardDto getCardOfMember(Long memberId) throws SQLException;
    public Map<String, List<TransactionDto>> getTransaction(Integer memberId, LocalDateTime updateDate) {
        List<TransactionDto> transactionList = new ArrayList<>();

        // member Id로 카드 목록 가져오기
        List<Card> cardList = cardRepository.findCardsByMember_Id(memberId);

        // 카드가 있으면
//        if(cardList.size() > 0){
//            for (Card card : cardList) {
//                // 카드 아이디로 거래내역 가져오기
//                List<Transaction> transactions = transactionRepository.findByCard_Id(card.getId());
//                for (Transaction transaction : transactions) {
//                    transactionList.add(transaction.toDto());
//                }
//            }
//        }
//        else{
//            transactionList.add(null);
//        }

        System.out.println("updateDate = " + updateDate);

        if(cardList.size() > 0){
            for (Card card : cardList) {
                // 카드 아이디로 거래내역 가져오기
                List<Transaction> transactions = transactionRepository.findTransactionsByDateAfterAndCard_Id(updateDate, card.getId());
                // 해당 카드의 거래 정보 업데이트 값이 없으면 다음 카드로
                if(transactions.isEmpty()){
                    System.out.println(" 현재 거래 정보가 없음!");
                    continue;
                }
                // 헤딩 카드의 거래 정보 업데이트 값이 있으면 거래 내역 추가하기
                for (Transaction transaction : transactions) {
                    transactionList.add(transaction.toDto());
                }
            }
        }
        else{
            transactionList.add(null);
        }

        // ************추가**************
        // 리스트 정렬이 필요! < 시간순
        Collections.sort(transactionList, new TransactionComparator());


        Map<String, List<TransactionDto>> response = new HashMap<>();


        response.put("transactionList", transactionList);

        return response;
    }
}
