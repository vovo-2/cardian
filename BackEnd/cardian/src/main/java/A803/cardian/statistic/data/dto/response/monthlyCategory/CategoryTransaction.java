package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryTransaction {
    private String categoryName;
    private int categoryConsume;
    private List<MonthlyTransactionDetails> monthlyTransactionDetailsList;

    private CategoryTransaction(String categoryName, int categoryConsume, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        this.categoryName = categoryName;
        this.categoryConsume = categoryConsume;
        this.monthlyTransactionDetailsList = monthlyTransactionDetailsList;
    }

    public static CategoryTransaction from(String categoryName, int categoryConsume, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        return new CategoryTransaction(categoryName, categoryConsume, monthlyTransactionDetailsList);
    }
}
