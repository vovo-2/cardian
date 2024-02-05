package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthlyTransaction {
    private int month;
    private List<MonthlyTransactionDetails> monthlyTransactionDetailsList;

    private CategoryMonthlyTransaction(int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        this.month = month;
        this.monthlyTransactionDetailsList = monthlyTransactionDetailsList;
    }

    public static CategoryMonthlyTransaction from(int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        return new CategoryMonthlyTransaction(month, monthlyTransactionDetailsList);
    }
}
