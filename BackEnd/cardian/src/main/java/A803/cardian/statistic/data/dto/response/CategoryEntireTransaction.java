package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryEntireTransaction {
    private String categoryCode;
    private List<CategoryMonthlyTransaction> categoryMonthlyTransactionList;

    private CategoryEntireTransaction(String categoryCode, List<CategoryMonthlyTransaction> categoryMonthlyTransactionList){
        this.categoryCode = categoryCode;
        this.categoryMonthlyTransactionList = categoryMonthlyTransactionList;
    }

    public static CategoryEntireTransaction from(String categoryCode, List<CategoryMonthlyTransaction> categoryMonthlyTransactionList){
        return new CategoryEntireTransaction(categoryCode, categoryMonthlyTransactionList);
    }
}
