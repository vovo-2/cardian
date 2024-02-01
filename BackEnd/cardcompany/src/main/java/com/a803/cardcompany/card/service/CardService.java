package com.a803.cardcompany.card.service;


import com.a803.cardcompany.card.dto.CardDto;
import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.card.mapper.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class CardService {

   @Autowired
   private final CardRepository cardRepository;


    // 카드 조회 - 멤버 아이디로 조회
   public List<CardDto> getCardOfMember(Integer memberId){
        List<CardDto> cardList = new ArrayList<>();

        List<Card> cards = cardRepository.findCardsByMember_Id(memberId);

        if(cards.size() > 0){
            for (Card card : cards) {
                cardList.add(card.toDto());
            }

        }else{
            cardList.add(null);
       }
    return cardList;
   }




}
