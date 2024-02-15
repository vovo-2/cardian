package A803.cardian.statistic.repository;

import A803.cardian.statistic.domain.AccumulateCategoryBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccumulateCategoryBenefitRepository extends JpaRepository<AccumulateCategoryBenefit, Integer> {
    Optional<AccumulateCategoryBenefit> findByMyCardIdAndCategoryBenefitId(int myCardId, int categoryBenefitId);
    List<AccumulateCategoryBenefit> findAccumulateCategoryBenefitsByMyCardIdAndCategoryCode(int myCardId, String categorycode);
}
