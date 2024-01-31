package A803.cardian.category.repository;

import A803.cardian.category.domain.CategoryIcon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryIconRepository extends JpaRepository<CategoryIcon,Integer> {

    @Query("SELECT c.iconImage FROM CategoryIcon c WHERE c.categoryCode = :categoryCode")
    Optional<String> findIconImageByCategoryCode(String categoryCode);

}
