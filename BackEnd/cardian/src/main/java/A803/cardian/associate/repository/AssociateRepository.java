package A803.cardian.associate.repository;

import A803.cardian.associate.domain.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssociateRepository extends JpaRepository<Associate, Integer> {
    @Query("SELECT a FROM Associate a WHERE a.name = :storeName")
    Optional<Associate> findByStoreName(String storeName);

    List<Associate> findByCategoryCode(String categoryCode);

    List<Associate> findByNameContaining(String search);

}
