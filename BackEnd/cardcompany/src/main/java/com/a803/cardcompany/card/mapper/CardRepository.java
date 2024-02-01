package com.a803.cardcompany.card.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {


        List<Card> findCardsByMember_Id(Integer memberId);

}
