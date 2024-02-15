package A803.cardian.statistic.data.dto.response.accumulateBenefit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerCategory {
    private String categoryCode;
    private int monthBenefit;
    private List<CategoryBenefitPerExceptionBenefit> categoryBenefitPerExceptionBenefitList;
    private List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList;

    private CategoryBenefitPerCategory(String categoryCode, int monthBenefit, List<CategoryBenefitPerExceptionBenefit> categoryBenefitPerExceptionBenefitList, List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList) {
        this.categoryCode = categoryCode;
        this.monthBenefit = monthBenefit;
        this.categoryBenefitPerExceptionBenefitList = categoryBenefitPerExceptionBenefitList;
        this.categoryBenefitPerCategoryBenefitList = categoryBenefitPerCategoryBenefitList;
    }



    public static CategoryBenefitPerCategory from(String categoryCode, int monthBenefit, List<CategoryBenefitPerExceptionBenefit> categoryBenefitPerExceptionBenefitList, List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList) {
        return new CategoryBenefitPerCategory(categoryCode, monthBenefit, categoryBenefitPerExceptionBenefitList, categoryBenefitPerCategoryBenefitList);
    }
}
