package com.a803.cardcompany.transaction.service;

import com.a803.cardcompany.transaction.dto.TransactionDto;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {


    //CardDto getCardOfMember(Long memberId) throws SQLException;
    List<TransactionDto> getTransaction(Integer cardId) throws SQLException;
}
