package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyConsumeDetailsWithCategorycode {
    private String categoryCode;
    private CategoryMonthlyConsumeDetails categoryMonthlyConsumeDetails;

    private CategoryMonthlyConsumeDetailsWithCategorycode(String categoryCode, CategoryMonthlyConsumeDetails categoryMonthlyConsumeDetails){
        this.categoryCode = categoryCode;
        this.categoryMonthlyConsumeDetails = categoryMonthlyConsumeDetails;
    }

    public static CategoryMonthlyConsumeDetailsWithCategorycode from(String categoryCode, CategoryMonthlyConsumeDetails categoryMonthlyConsumeDetails){
        return new CategoryMonthlyConsumeDetailsWithCategorycode(categoryCode, categoryMonthlyConsumeDetails);
    }
}
