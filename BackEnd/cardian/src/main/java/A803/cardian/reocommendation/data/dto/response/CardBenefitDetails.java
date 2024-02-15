package A803.cardian.reocommendation.data.dto.response;

import A803.cardian.associate.domain.Associate;
import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CardBenefitDetails {
    private String associateName;
    private int discountAmount;
    private String sign;

    //예외혜택일 때
    public static CardBenefitDetails from(ExceptionBenefit exceptionBenefit, Associate associate) {
        return CardBenefitDetails.builder()
                .associateName(associate.getName())
                .discountAmount(exceptionBenefit.getDiscountAmount())
                .sign(exceptionBenefit.getSign())
                .build();
    }
    //카테고리혜택일 때
    public static CardBenefitDetails from(CategoryBenefit categoryBenefit, Associate associate){
        return CardBenefitDetails.builder()
                .associateName(associate.getName())
                .discountAmount(categoryBenefit.getDiscountAmount())
                .sign(categoryBenefit.getSign())
                .build();
    }

}
