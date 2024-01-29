package com.a803.cardcompany.transaction.mapper;

import com.a803.cardcompany.card.mapper.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public Transaction findByCardId(Integer id);
}
