package com.a803.cardcompany.card.service;

import com.a803.cardcompany.card.dto.CardDto;
import com.a803.cardcompany.card.mapper.Card;
import com.a803.cardcompany.card.mapper.CardRepository;
import com.a803.cardcompany.member.dto.MemberDto;
import com.a803.cardcompany.member.mapper.Member;
import com.a803.cardcompany.member.mapper.MemberRepository;
import com.a803.cardcompany.member.service.MemberServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }




    @Override
    public CardDto getCard(Integer id) throws SQLException {
        CardDto cardDto = cardRepository.findById(id).get().toDto();

        return cardDto;
    }

    @Override
    public List<CardDto> getCardOfMember(Integer memberId) throws SQLException {
        List<Card> cardList = cardRepository.findByMemberId(memberId);
//        CardDto cardDto = cardRepository.findByMemberId(memberId).toDto();

        List<CardDto> cardDtoList = new ArrayList<>();

        for (Card card : cardList) {
//            cardList.add(cardRepository.findAll()
//                    .stream()
//                    .map(Card::toDto)
//                    .collect(Collectors.toList()););

            cardDtoList.add(card.toDto());
//            cardList.add(cardRepository.findByMemberId(memberId)
//                    .stream().map(Card::toDto).collect(Collectors.toList()));
        }

//        cardList = cardRepository.findAll()
//                                .stream()
//                                .map(Card::toDto)
//                                .collect(Collectors.toList());

        return cardDtoList;
    }
}
