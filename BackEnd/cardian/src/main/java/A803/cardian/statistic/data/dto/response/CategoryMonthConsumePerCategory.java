package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//카테고리별
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthConsumePerCategory {
    private String categoryCode;
    private List<CategoryMonthConsumeDetails> categoryMonthConsumeDetailsList;

    private CategoryMonthConsumePerCategory(String categoryCode, List<CategoryMonthConsumeDetails> categoryMonthConsumeDetailsList){
        this.categoryCode = categoryCode;
        this.categoryMonthConsumeDetailsList = categoryMonthConsumeDetailsList;
    }

    public static CategoryMonthConsumePerCategory from(String categoryCode, List<CategoryMonthConsumeDetails> categoryMonthConsumeDetailsList){
        return new CategoryMonthConsumePerCategory(categoryCode, categoryMonthConsumeDetailsList);
    }
}
