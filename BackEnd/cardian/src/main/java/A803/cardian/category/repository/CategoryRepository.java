package A803.cardian.category.repository;

import A803.cardian.category.domain.CategoryIcon;
import A803.cardian.category.domain.SubCommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<SubCommonCode,Integer> {

}
