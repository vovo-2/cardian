package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryDayTransaction {
    private int day;
    private List<CategoryDayTransactionDetails> categoryDayTransactionDetailsList;

    private CategoryDayTransaction(int day, List<CategoryDayTransactionDetails> categoryDayTransactionDetailsList){
        this.day = day;
        this.categoryDayTransactionDetailsList = categoryDayTransactionDetailsList;
    }

    public static CategoryDayTransaction from(int day, List<CategoryDayTransactionDetails> categoryDayTransactionDetailsList){
        return new CategoryDayTransaction(day, categoryDayTransactionDetailsList);
    }
}
