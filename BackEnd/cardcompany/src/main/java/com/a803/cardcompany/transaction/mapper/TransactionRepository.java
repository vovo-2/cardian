package com.a803.cardcompany.transaction.mapper;

import com.a803.cardcompany.card.mapper.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    List<Transaction> findByCard_Id(Integer id);

//    List<Transaction> findTransactionsByCard_IdAndDateIsAfter(Integer id, LocalDateTime updateDate);
    List<Transaction> findTransactionsByDateAfterAndCard_Id(LocalDateTime updateDate, Integer id);

    List<Transaction> findTransactionsByDateAfterAndCard(LocalDateTime updateDate, Card card);

    List<Transaction> findTransactionsByDateAfter(LocalDateTime updateDate);

}
