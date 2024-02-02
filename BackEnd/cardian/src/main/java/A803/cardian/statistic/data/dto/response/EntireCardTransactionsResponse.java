package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EntireCardTransactionsResponse {
    private int memberId;
    private List<MonthlyTransactionDetailsWithMonth> monthlyTransactionDetailsWithMonthList;

    private EntireCardTransactionsResponse(int memberId, List<MonthlyTransactionDetailsWithMonth> monthlyTransactionDetailsWithMonthList){
        this.memberId = memberId;
        this.monthlyTransactionDetailsWithMonthList = monthlyTransactionDetailsWithMonthList;
    }

    public static EntireCardTransactionsResponse toResponse(int memberId, List<MonthlyTransactionDetailsWithMonth> monthlyTransactionDetailsWithMonthList){
        return new EntireCardTransactionsResponse(memberId, monthlyTransactionDetailsWithMonthList);
    }

}
