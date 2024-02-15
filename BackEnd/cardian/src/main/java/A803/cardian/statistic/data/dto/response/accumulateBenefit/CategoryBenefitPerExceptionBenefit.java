package A803.cardian.statistic.data.dto.response.accumulateBenefit;

import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerExceptionBenefit {
    private ExceptionBenefit exceptionBenefit;
    private int benefitAmount;

    private CategoryBenefitPerExceptionBenefit(ExceptionBenefit exceptionBenefit, int benefitAmount){
        this.exceptionBenefit = exceptionBenefit;
        this.benefitAmount = benefitAmount;
    }

    public static CategoryBenefitPerExceptionBenefit from(ExceptionBenefit exceptionBenefit, int benefitAmount) {
        return new CategoryBenefitPerExceptionBenefit(exceptionBenefit, benefitAmount);
    }
}
