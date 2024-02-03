package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryTransactionResponse {
    private int memberId;
    private List<CategoryEntireTransaction> categoryEntireTransactionList;

    private CategoryTransactionResponse(int memberId, List<CategoryEntireTransaction> categoryEntireTransactionList){
        this.memberId = memberId;
        this.categoryEntireTransactionList = categoryEntireTransactionList;
    }

    public static CategoryTransactionResponse toResponse(int memberId, List<CategoryEntireTransaction> categoryEntireTransactionList){
        return new CategoryTransactionResponse(memberId, categoryEntireTransactionList);
    }
}
