package A803.cardian.statistic.data.dto.response.category;

import A803.cardian.statistic.data.dto.response.MonthlyTransactionDetails;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class YearTransactionDetails {
    private int month;
    private List<MonthlyTransactionDetails> monthlyTransactionDetailsList;

    private YearTransactionDetails(int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        this.month = month;
        this.monthlyTransactionDetailsList = monthlyTransactionDetailsList;
    }

    public static YearTransactionDetails from(int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        return new YearTransactionDetails(month, monthlyTransactionDetailsList);
    }
}
