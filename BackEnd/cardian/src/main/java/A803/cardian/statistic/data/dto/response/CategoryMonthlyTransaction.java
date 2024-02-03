package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyTransaction {
    private int month;
    private List<CategoryDailyTransaction> categoryDailyTransactionList;

    private CategoryMonthlyTransaction(int month, List<CategoryDailyTransaction> categoryDailyTransactionList){
        this.month = month;
        this.categoryDailyTransactionList = categoryDailyTransactionList;
    }

    public static CategoryMonthlyTransaction from(int month, List<CategoryDailyTransaction> categoryDailyTransactionList){
        return new CategoryMonthlyTransaction(month, categoryDailyTransactionList);
    }
}
