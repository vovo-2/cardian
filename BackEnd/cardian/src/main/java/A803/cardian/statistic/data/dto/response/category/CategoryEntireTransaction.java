package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryEntireTransaction {
    private String categoryName;
    private List<CategoryMonthlyTransaction> categoryMonthlyTransactionList;

    private CategoryEntireTransaction(String categoryName, List<CategoryMonthlyTransaction> categoryMonthlyTransactionList){
        this.categoryName = categoryName;
        this.categoryMonthlyTransactionList = categoryMonthlyTransactionList;
    }

    public static CategoryEntireTransaction from(String categoryCode, List<CategoryMonthlyTransaction> categoryMonthlyTransactionList){
        return new CategoryEntireTransaction(categoryCode, categoryMonthlyTransactionList);
    }
}
