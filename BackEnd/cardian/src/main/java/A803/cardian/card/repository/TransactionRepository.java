package A803.cardian.card.repository;

import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findTransactionsByMyCardIdAndDay(int myCardId, LocalDate localDate);
    List<Transaction> findTransactionsByMyCardAndDateAfter(MyCard myCard, LocalDateTime localDateTime);
    List<Transaction> findTransactionsByMyCardAndDayBetween(MyCard myCard, LocalDate day, LocalDate day2);
}
