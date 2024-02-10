package A803.cardian.benefit.repository;

import A803.cardian.benefit.domain.ExceptionBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExceptionBenefitRepository extends JpaRepository<ExceptionBenefit, Integer>{
    //거래내역의 제휴사(1)와 내카드아이디로 가져온 카드의 카드아이디(2)로 예외혜택 가져오기
    Optional<ExceptionBenefit> findByAssociateIdAndCardId(int associateId, int cardId);
    //카드아이디와 카테고리코드로 예외혜택 가져오기
    Optional<ExceptionBenefit> findByCardIdAndCategoryCode(int cardId, String categoryCode);
    List<ExceptionBenefit> findExceptionBenefitsByCardIdAndCategoryCode(int cardId, String categoryCode);
    /*
     * 작성자 : 정여민
     * 작성일시 : 2024.01.31
     */
    // 카드 아이디, 카드사 아이디, 카테고리 코드로 예외 혜택 가져오기 - 1개만!
    @Query("select e from ExceptionBenefit e where e.cardId= :cardId and e.companyId = :companyId and e.categoryCode = :categoryCode")
    Optional<ExceptionBenefit> findByCardIdAndCompanyIdAndCategoryCode(Integer cardId, Integer companyId, String categoryCode);

    @Query("select e from ExceptionBenefit e where e.cardId= :cardId and e.associateId= :associateId")
    Optional<ExceptionBenefit> findByCardIdAndAssociateId(Integer cardId, Integer associateId);


}
