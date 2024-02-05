package A803.cardian.goal.repository;

import A803.cardian.goal.data.dto.response.GoalAchieve;
import A803.cardian.goal.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Integer> {
    @Query("SELECT g.achieve FROM Goal g WHERE g.myCard.id = :myCardId")
    Optional<Boolean> findByMyCard_Id(Integer myCardId);

    Goal findByMyCardId(int myCardId);
}
