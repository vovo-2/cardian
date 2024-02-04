package A803.cardian.member.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import A803.cardian.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findById(Integer memberId);

    // Member의 updateDate 업데이트
    @Modifying
    @Query("UPDATE Member m SET m.updateDate = :newUpdateDate WHERE m.id = :memberId")
    void updateMemberUpdateDate(@Param("memberId") Integer memberId, @Param("newUpdateDate") LocalDateTime newUpdateDate);

}
