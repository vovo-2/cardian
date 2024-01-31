package A803.cardian.statistic.domain.repository;

import A803.cardian.statistic.domain.AccumulateBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccumulateBenefitRepository extends JpaRepository<AccumulateBenefit, Integer> {
    @Query("select a from AccumulateBenefit a where a.cardId = :cardId and a.categoryCode = :categoryCode")
    Optional<AccumulateBenefit> getAccumulateBenefitWithCardIdAndCategoryCode(int cardId, String categoryCode);
}

