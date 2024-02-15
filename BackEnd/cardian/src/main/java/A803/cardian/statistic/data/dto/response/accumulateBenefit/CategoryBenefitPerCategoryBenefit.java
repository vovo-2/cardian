package A803.cardian.statistic.data.dto.response.accumulateBenefit;

import A803.cardian.benefit.domain.CategoryBenefit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerCategoryBenefit {
    private CategoryBenefit categoryBenefit;
    private int benefitAmount;

    private CategoryBenefitPerCategoryBenefit(CategoryBenefit categoryBenefit, int benefitAmount){
        this.categoryBenefit = categoryBenefit;
        this.benefitAmount = benefitAmount;
    }

    public static CategoryBenefitPerCategoryBenefit from(CategoryBenefit categoryBenefit, int benefitAmount){
        return new CategoryBenefitPerCategoryBenefit(categoryBenefit, benefitAmount);
    }

}
