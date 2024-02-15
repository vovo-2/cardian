package A803.cardian.benefit.data.dto;

import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class BenefitStore {

    private String storeName;
    private int discountAmount;
    private String sign;

    // ExceptionBenefit과 StoreName 입력 받아서 Dto 반환
    public static BenefitStore from(ExceptionBenefit exceptionBenefit, String storeName){

        return BenefitStore.builder()
                .storeName(storeName)
                .discountAmount(exceptionBenefit.getDiscountAmount())
                .sign(exceptionBenefit.getSign())
                .build();
    }

    // Associate 입력받아서 Dto 반환
    public static BenefitStore from(CategoryBenefit categoryBenefit, String storeName){
        return BenefitStore.builder()
                .storeName(storeName)
                .discountAmount(categoryBenefit.getDiscountAmount())
                .sign(categoryBenefit.getSign())
                .build();
    }
}
