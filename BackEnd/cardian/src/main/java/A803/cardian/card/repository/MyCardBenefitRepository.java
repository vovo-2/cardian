package A803.cardian.card.repository;

import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
import A803.cardian.card.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*   작성자 : 정여민
*   작성일시 : 2024.01.29
*
 */


@Repository
public interface MyCardBenefitRepository extends JpaRepository<Card, Integer> {

    // 카드 아이디가 주어지면
    // 1. 카테고리 혜택 (category_benefit), 상세코드 (sub_common_code의 category_code), 카테고리 아이콘 category_code join icon_image 넘겨주기
    // category benefit, sub_common_code, category_icon
    //
    // 2. category_code 같은 거 조회(join조건), card_id 로 조회
    // SELECT cb.card_id, cb.category_code, ci.icon_image, cb.discount_amount, cb.sign, cb.categorybenefit_id, scc.name
    //FROM category_benefit cb, sub_common_code scc, category_icon ci where cb.category_code = scc.detail_code and cb.category_code = ci.category_code and card_id = 1;


    // Spring Data JPA Projections : 카드 아이디를 가져와서 혜택 정보 조회 후 반환
    // Native Query 사용 -> Data Mapping은 interface로 해야 오류가 안 남
    @Query(value = "SELECT cb.card_id as cardId, cb.category_code as categoryCode, ci.icon_image as iconImage, cb.discount_amount as discountAmount, cb.sign as sign, cb.categorybenefit_id as categorybenefitId, scc.name as name " +
            "FROM category_benefit cb, sub_common_code scc, category_icon ci where cb.category_code = scc.detail_code and cb.category_code = ci.category_code and cb.card_id =:cardId", nativeQuery = true)
    List<CardCategoryBenefitResponses> findProjectBenefitCodeByCardId(@Param("cardId") Integer cardId);

}
