package A803.cardian.card.data.dto.response;

import A803.cardian.benefit.data.dto.BenefitStore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


/*
*   작성자 : 정여민
*   작성 일시 : 2024.01.31
*   업데이트 : 2024.01.31
*   내용 : 카드 > 혜택 > 상세 혜택 반환할 DTO
*
*/
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CardBenefitCategoryResponse {

    private BenefitStore exceptionBenefitStore;

    private List<BenefitStore> storeList;

    private CardBenefitCategoryResponse(BenefitStore exceptionBenefitStore, List<BenefitStore> storeList){
        this.exceptionBenefitStore = exceptionBenefitStore;
        this.storeList = storeList;
    }

    public static CardBenefitCategoryResponse toResponse(BenefitStore benefitStore, List<BenefitStore> storeList){
        return new CardBenefitCategoryResponse(benefitStore, storeList);
    }

}
