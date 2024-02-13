package A803.cardian.goal.repository;

import A803.cardian.goal.data.dto.response.GoalAchieve;
import A803.cardian.goal.domain.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal,Integer> {
    @Query("SELECT g.achieve FROM Goal g WHERE g.myCard.id = :myCardId")
    Optional<Boolean> findByMyCard_Id(Integer myCardId);

    Goal findByMyCardId(int myCardId);

    @Modifying
    @Query("UPDATE Goal g SET g.accumulate = :accumulate WHERE g.myCard.id = :myCardId")
    void updateGoal(@Param("accumulate") int accumulate, @Param("myCardId") int myCardId);

    @Modifying
    @Query("UPDATE Goal g SET g.accumulate = :accumulate ,g.achieve = :achieve WHERE g.myCard.id = :myCardId")
    void updateGoalEntire(@Param("accumulate") int accumulate, @Param("achieve") boolean achieve,@Param("myCardId") int myCardId);
}
