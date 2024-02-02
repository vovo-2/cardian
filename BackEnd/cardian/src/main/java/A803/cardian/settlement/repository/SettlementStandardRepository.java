package A803.cardian.settlement.repository;

import A803.cardian.settlement.domain.SettlementStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SettlementStandardRepository extends JpaRepository<SettlementStandard,Integer> {

    List<SettlementStandard> findAll();
}
