package A803.cardian.statistic.data.dto.response.category;

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
    private List<CategoryTransaction> categoryTransactionList;

    private CategoryMonthTransactionResponse(int memberId, int month, List<CategoryTransaction> categoryTransactionList){
        this.memberId = memberId;
        this.month = month;
        this.categoryTransactionList = categoryTransactionList;
    }

    public static CategoryMonthTransactionResponse toResponse(int memberId, int month, List<CategoryTransaction> categoryTransactionList){
        return new CategoryMonthTransactionResponse(memberId, month, categoryTransactionList);
    }
}
