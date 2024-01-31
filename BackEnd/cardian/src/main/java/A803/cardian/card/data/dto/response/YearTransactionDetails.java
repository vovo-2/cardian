package A803.cardian.card.data.dto.response;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class YearTransactionDetails {
    private int month;

    private List<MonthlyTransactionDetails> monthlyTransactionDetailsList;

    private YearTransactionDetails(int myCardId, int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        this.month = month;
        this.monthlyTransactionDetailsList = monthlyTransactionDetailsList;
    }

    public static YearTransactionDetails toResponse(int myCardId, int month, List<MonthlyTransactionDetails> monthlyTransactionDetailsList){
        return new YearTransactionDetails(myCardId, month, monthlyTransactionDetailsList);
    }
}
