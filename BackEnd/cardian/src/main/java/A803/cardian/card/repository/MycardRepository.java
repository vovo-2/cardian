package A803.cardian.card.repository;

import A803.cardian.card.domain.MyCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyCardRepository extends JpaRepository<MyCard,Integer> {
}
