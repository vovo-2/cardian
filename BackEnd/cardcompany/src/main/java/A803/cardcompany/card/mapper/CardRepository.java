package com.a803.cardcompany.card.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {


    public Optional<Card> findById(Integer id);
    public List<Card> findByMemberId(Integer id);
}
