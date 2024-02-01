package A803.cardian.category.repository;

import A803.cardian.category.domain.SubCommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubCommonRepository extends JpaRepository<SubCommonCode,Integer> {
    @Query("SELECT s.name FROM SubCommonCode s WHERE s.detailCode = :detailCode")
    Optional<String> findByDetailCode(String detailCode);



}
