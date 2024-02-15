package A803.cardian.statistic.repository;

import A803.cardian.statistic.domain.CategoryMonthConsume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryMonthConsumeRepository extends JpaRepository<CategoryMonthConsume, Integer> {
    Optional<CategoryMonthConsume> findByCategoryCodeAndMyCardIdAndMonth(String categoryCode, int myCardId, int month);
}
