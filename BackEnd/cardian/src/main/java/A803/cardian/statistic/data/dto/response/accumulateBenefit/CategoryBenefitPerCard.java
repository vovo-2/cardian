package A803.cardian.statistic.data.dto.response.accumulateBenefit;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerCard {
    private int myCardId;
    private List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList;

    private CategoryBenefitPerCard(int myCardId, List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList){
        this.myCardId = myCardId;
        this.categoryBenefitPerCategoryList = categoryBenefitPerCategoryList;
    }

    public static CategoryBenefitPerCard from(int myCardId, List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList){
        return new CategoryBenefitPerCard(myCardId, categoryBenefitPerCategoryList);
    }
}
