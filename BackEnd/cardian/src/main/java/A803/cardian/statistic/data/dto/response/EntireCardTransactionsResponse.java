package A803.cardian.statistic.data.dto.response;

import A803.cardian.statistic.data.dto.response.category.YearTransactionDetails;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EntireCardTransactionsResponse {
    private int memberId;
    private List<YearTransactionDetails> yearTransactionDetailsList;

    private EntireCardTransactionsResponse(int memberId, List<YearTransactionDetails> yearTransactionDetailsList){
        this.memberId = memberId;
        this.yearTransactionDetailsList = yearTransactionDetailsList;
    }

    public static EntireCardTransactionsResponse toResponse(int memberId, List<YearTransactionDetails> yearTransactionDetailsList){
        return new EntireCardTransactionsResponse(memberId, yearTransactionDetailsList);
    }

}
