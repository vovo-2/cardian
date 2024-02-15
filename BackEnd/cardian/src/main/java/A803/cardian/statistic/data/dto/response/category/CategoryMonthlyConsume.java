package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyConsume {
    private int month;
    private int monthlyEntireConsume;
    private List<CategoryMonthlyConsumeDetails> categoryMonthlyConsumeDetails;

    private CategoryMonthlyConsume(int month, int monthlyEntireConsume, List<CategoryMonthlyConsumeDetails> categoryMonthlyConsumeDetails) {
        this.month = month;
        this.monthlyEntireConsume = monthlyEntireConsume;
        this.categoryMonthlyConsumeDetails = categoryMonthlyConsumeDetails;
    }

    public static CategoryMonthlyConsume from(int month, int monthlyEntireConsume, List<CategoryMonthlyConsumeDetails> categoryMonthlyConsumeDetails){
        return new CategoryMonthlyConsume(month, monthlyEntireConsume, categoryMonthlyConsumeDetails);
    }
}
