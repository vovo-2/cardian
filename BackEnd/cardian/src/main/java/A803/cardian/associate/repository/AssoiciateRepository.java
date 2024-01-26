package A803.cardian.associate.repository;

import A803.cardian.associate.domain.Associate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssoiciateRepository extends JpaRepository<Associate, Integer> {
}
