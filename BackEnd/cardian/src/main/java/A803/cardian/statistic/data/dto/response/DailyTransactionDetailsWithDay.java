package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DailyTransactionDetailsWithDay {
    private int day;
    private List<DailyTransactionDetails> dailyTransactionDetailsList;

    private DailyTransactionDetailsWithDay(int day, List<DailyTransactionDetails> dailyTransactionDetailsList){
        this.day = day;
        this.dailyTransactionDetailsList = dailyTransactionDetailsList;
    }

    public static DailyTransactionDetailsWithDay from(int day, List<DailyTransactionDetails> dailyTransactionDetailsList){
        return new DailyTransactionDetailsWithDay(day, dailyTransactionDetailsList);
    }
}
