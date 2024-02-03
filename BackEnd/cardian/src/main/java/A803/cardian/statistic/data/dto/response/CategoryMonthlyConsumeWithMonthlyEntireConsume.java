package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyConsumeWithMonthlyEntireConsume {
    private int month;
    private int monthlyEntireConsume;
    private List<CategoryMonthlyConsumeDetailsWithCategorycode> categoryMonthlyConsumeDetailsWithCategorycode;

    private CategoryMonthlyConsumeWithMonthlyEntireConsume(int month, int monthlyEntireConsume, List<CategoryMonthlyConsumeDetailsWithCategorycode> categoryMonthlyConsumeDetailsWithCategorycode) {
        this.month = month;
        this.monthlyEntireConsume = monthlyEntireConsume;
        this.categoryMonthlyConsumeDetailsWithCategorycode = categoryMonthlyConsumeDetailsWithCategorycode;
    }

    public static CategoryMonthlyConsumeWithMonthlyEntireConsume from(int month, int monthlyEntireConsume, List<CategoryMonthlyConsumeDetailsWithCategorycode> categoryMonthlyConsumeDetailsWithCategorycode){
        return new CategoryMonthlyConsumeWithMonthlyEntireConsume(month, monthlyEntireConsume, categoryMonthlyConsumeDetailsWithCategorycode);
    }
}
