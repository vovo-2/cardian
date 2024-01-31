package A803.cardian.benefit.repository;

import A803.cardian.benefit.domain.ExceptionBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ExceptionBenefitRepository extends JpaRepository<ExceptionBenefit, Integer>{
    //거래내역의 제휴사(1)와 내카드아이디로 가져온 카드의 카드아이디(2)로 예외혜택 가져오기
    Optional<ExceptionBenefit> findByAssociateIdAndCardId(int associateId, int cardId);
}
