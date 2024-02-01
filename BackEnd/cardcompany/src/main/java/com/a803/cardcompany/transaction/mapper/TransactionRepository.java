package com.a803.cardcompany.transaction.mapper;

import com.a803.cardcompany.card.mapper.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCard_Id(Integer id);
}
