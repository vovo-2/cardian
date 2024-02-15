package A803.cardian.associate.repository;

import A803.cardian.associate.domain.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssociateRepository extends JpaRepository<Associate, Integer> {
    Optional<Associate> findByName(String name);

    List<Associate> findByCategoryCode(String categoryCode);

    List<Associate> findByNameContaining(String search);

    Optional<Associate> findById(Integer id);

}
