package A803.cardcompany.transaction.service;

import com.a803.cardcompany.transaction.dto.TransactionDto;
import com.a803.cardcompany.transaction.mapper.Transaction;
import com.a803.cardcompany.transaction.mapper.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{


    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    @Override
    public List<TransactionDto> getTransaction(Integer cardId) throws SQLException {

        List<TransactionDto> transactionList = new ArrayList<>();

        transactionList = transactionRepository.findAll()
                                            .stream()
                                            .map(Transaction::toDto)
                                            .collect(Collectors.toList());

        return transactionList;
    }




}
