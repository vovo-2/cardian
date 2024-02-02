package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyConsumeWithMonth {
    private int month;
    private List<CategoryMonthlyConsume> categoryMonthlyConsumeList;

    private CategoryMonthlyConsumeWithMonth(int month, List<CategoryMonthlyConsume> categoryMonthlyConsumeList){
        this.month = month;
        this.categoryMonthlyConsumeList = categoryMonthlyConsumeList;
    }

    public static CategoryMonthlyConsumeWithMonth from(int month, List<CategoryMonthlyConsume> categoryMonthlyConsumeList){
        return new CategoryMonthlyConsumeWithMonth(month, categoryMonthlyConsumeList);
    }
}
