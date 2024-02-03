package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryDailyTransaction {
    private int day;
    private List<CategoryTransactionDetails> categoryTransactionDetailsList;

    private CategoryDailyTransaction(int day, List<CategoryTransactionDetails> categoryTransactionDetailsList){
        this.day = day;
        this.categoryTransactionDetailsList = categoryTransactionDetailsList;
    }

    public static CategoryDailyTransaction from(int day, List<CategoryTransactionDetails> categoryTransactionDetailsList){
        return new CategoryDailyTransaction(day, categoryTransactionDetailsList);
    }
}
