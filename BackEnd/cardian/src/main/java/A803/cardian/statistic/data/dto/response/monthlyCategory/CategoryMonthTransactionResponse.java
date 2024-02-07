package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthTransactionResponse {
    private int memberId;
    private int month;
    private int entireCategoryConsume;
    private List<CategoryTransaction> categoryTransactionList;

    private CategoryMonthTransactionResponse(int memberId, int month, int entireCategoryConsume, List<CategoryTransaction> categoryTransactionList){
        this.memberId = memberId;
        this.month = month;
        this.entireCategoryConsume = entireCategoryConsume;
        this.categoryTransactionList = categoryTransactionList;
    }

    public static CategoryMonthTransactionResponse toResponse(int memberId, int month, int entireCategoryConsume, List<CategoryTransaction> categoryTransactionList){
        return new CategoryMonthTransactionResponse(memberId, month, entireCategoryConsume, categoryTransactionList);
    }
}
