package A803.cardian.member.repository;

import java.util.Optional;

import A803.cardian.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findById(Integer memberId);


}
