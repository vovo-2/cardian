package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MonthlyTransactionDetails {
    private int day;
    private List<DailyTransactionDetails> dailyTransactionDetailsList;

    private MonthlyTransactionDetails(int day, List<DailyTransactionDetails> dailyTransactionDetailsList){
        this.day = day;
        this.dailyTransactionDetailsList = dailyTransactionDetailsList;
    }

    public static MonthlyTransactionDetails from(int day, List<DailyTransactionDetails> dailyTransactionDetailsList){
        return new MonthlyTransactionDetails(day, dailyTransactionDetailsList);
    }
}
