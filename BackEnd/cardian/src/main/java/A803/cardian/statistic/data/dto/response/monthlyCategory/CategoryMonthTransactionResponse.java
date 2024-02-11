package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthTransactionResponse {
    private String categoryName;
    private int month;
    private List<MonthlyTransactionDetails> monthlyTransactionDetailsList;

    private CategoryMonthTransactionResponse(String categoryName, int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        this.categoryName = categoryName;
        this.month = month;
        this.monthlyTransactionDetailsList = monthlyTransactionDetailsList;
    }

    public static CategoryMonthTransactionResponse toResponse(String categoryName, int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        return new CategoryMonthTransactionResponse(categoryName, month, monthlyTransactionDetailsList);
    }
    }
