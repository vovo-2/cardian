package A803.cardian.statistic.data.dto.response.category;

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
    private List<CategoryDayTransaction> categoryDayTransactionList;

    private CategoryTransaction(String categoryName, int categoryConsume, List<CategoryDayTransaction> categoryDayTransactionList){
        this.categoryName = categoryName;
        this.categoryConsume = categoryConsume;
        this.categoryDayTransactionList = categoryDayTransactionList;
    }

    public static CategoryTransaction from(String categoryName, int categoryConsume, List<CategoryDayTransaction> categoryDayTransactionList){
        return new CategoryTransaction(categoryName, categoryConsume, categoryDayTransactionList);
    }
}
