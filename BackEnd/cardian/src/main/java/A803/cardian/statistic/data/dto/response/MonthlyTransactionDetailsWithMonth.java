package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MonthlyTransactionDetailsWithMonth {
    private int month;
    private List<DailyTransactionDetailsWithDay> dailyTransactionDetailsWithDayList;

    private MonthlyTransactionDetailsWithMonth(int month, List<DailyTransactionDetailsWithDay> dailyTransactionDetailsWithDayList){
        this.month = month;
        this.dailyTransactionDetailsWithDayList = dailyTransactionDetailsWithDayList;
    }

    public static MonthlyTransactionDetailsWithMonth from(int month, List<DailyTransactionDetailsWithDay> dailyTransactionDetailsWithDayList){
        return new MonthlyTransactionDetailsWithMonth(month, dailyTransactionDetailsWithDayList);
    }
}
