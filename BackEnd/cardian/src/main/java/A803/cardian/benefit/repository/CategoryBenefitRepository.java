package A803.cardian.benefit.repository;

import A803.cardian.benefit.domain.CategoryBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryBenefitRepository extends JpaRepository<CategoryBenefit, Integer> {
    //카드카테고리매핑객체에서 가져옴
}
