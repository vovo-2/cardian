package A803.cardian.settlement.repository;

import A803.cardian.settlement.domain.Settlement;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SettlementRepository extends JpaRepository<Settlement,Integer> {
    @Query("SELECT s.salary FROM Settlement s WHERE s.member.id = :memberId")
    Optional<Integer> findByMember_Id(Integer memberId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Settlement s SET s.salary = :salary WHERE s.member.id = :member")
    void updateSalary(@Param("member") Integer member_id, @Param("salary") Integer salary);

}
