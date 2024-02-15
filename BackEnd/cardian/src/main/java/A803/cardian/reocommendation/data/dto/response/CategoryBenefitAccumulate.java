package A803.cardian.reocommendation.data.dto.response;

import A803.cardian.benefit.domain.CategoryBenefit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitAccumulate {
    private CategoryBenefit categoryBenefit;
    private int benefitAccumulate;

    private CategoryBenefitAccumulate(CategoryBenefit categoryBenefit, int benefitAccumulate){
        this.categoryBenefit = categoryBenefit;
        this.benefitAccumulate= benefitAccumulate;
    }

    public static CategoryBenefitAccumulate from(CategoryBenefit categoryBenefit, int benefitAccumulate){
        return new CategoryBenefitAccumulate(categoryBenefit, benefitAccumulate);
    }
}
