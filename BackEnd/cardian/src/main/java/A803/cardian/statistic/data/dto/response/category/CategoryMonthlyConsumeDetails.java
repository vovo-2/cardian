package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyConsumeDetails {
    private String categoryName;
    private int monthlyConsumePerCategory;

    private CategoryMonthlyConsumeDetails(String categoryName, int monthlyConsumePerCategory){
        this.categoryName = categoryName;
        this.monthlyConsumePerCategory = monthlyConsumePerCategory;
    }

    public static CategoryMonthlyConsumeDetails from(String categoryCode, int monthlyConsumePerCategory){
        return new CategoryMonthlyConsumeDetails(categoryCode, monthlyConsumePerCategory);
    }
}
