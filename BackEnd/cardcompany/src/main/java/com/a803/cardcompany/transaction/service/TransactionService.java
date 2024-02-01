package com.a803.cardcompany.transaction.service;

import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.card.mapper.CardRepository;
import com.a803.cardcompany.transaction.dto.TransactionDto;
import com.a803.cardcompany.transaction.mapper.Transaction;
import com.a803.cardcompany.transaction.mapper.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, List<TransactionDto>> getTransaction(Integer memberId) {
        List<TransactionDto> transactionList = new ArrayList<>();

        // member Id로 카드 목록 가져오기
        List<Card> cardList = cardRepository.findCardsByMember_Id(memberId);

        // 카드가 있으면
        if(cardList.size() > 0){
            for (Card card : cardList) {
                // 카드 아이디로 거래내역 가져오기
                List<Transaction> transactions = transactionRepository.findByCard_Id(card.getId());
                for (Transaction transaction : transactions) {
                    transactionList.add(transaction.toDto());
                }
            }
        }
        else{
            transactionList.add(null);
        }

        Map<String, List<TransactionDto>> response = new HashMap<>();

        response.put("transactionList", transactionList);

        return response;
    }
}
