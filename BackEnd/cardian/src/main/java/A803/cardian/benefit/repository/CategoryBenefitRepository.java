package A803.cardian.benefit.repository;

import A803.cardian.benefit.domain.CategoryBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CategoryBenefitRepository extends JpaRepository<CategoryBenefit, Integer> {
    //카드카테고리매핑객체에서 가져옴
    /*
     *  작성자 : 정여민
     *  작성 일시 : 2024.01.31
     *  업데이트 : 2024.01.31
     *  4-1. 카드 아이디, 카테고리 코드 -> 카테고리 혜택 => 해당 카테고리의 카테고리혜택 아이디, 할인크기, 기호 가져오기
        4-2. 카드 카테고리 매핑 테이블에 가서 제휴사 아이디
        4-3. 상호명 가져오기

     */
    Optional<CategoryBenefit> findCategoryBenefitByCardIdAndCategoryCode(Integer cardId, String categoryCode);

    List<CategoryBenefit> findCategoryBenefitsByCardId(Integer cardId);

}
