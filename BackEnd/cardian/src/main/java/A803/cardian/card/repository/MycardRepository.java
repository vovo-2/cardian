package A803.cardian.card.repository;

import A803.cardian.card.domain.MyCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCardRepository extends JpaRepository<MyCard,Integer> {
}
