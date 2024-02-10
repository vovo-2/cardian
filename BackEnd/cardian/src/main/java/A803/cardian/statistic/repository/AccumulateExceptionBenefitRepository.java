package A803.cardian.statistic.repository;

import A803.cardian.card.domain.MyCard;
import A803.cardian.statistic.domain.AccumulateExceptionBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccumulateExceptionBenefitRepository extends JpaRepository<AccumulateExceptionBenefit, Integer> {
    Optional<AccumulateExceptionBenefit> findByMyCardIdAndCategoryCode(int myCardId, String categoryCode);
}
