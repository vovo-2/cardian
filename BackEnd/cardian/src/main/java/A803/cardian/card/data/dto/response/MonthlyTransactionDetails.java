package A803.cardian.card.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class MonthlyTransactionDetails {

    private int day;

    @Builder.Default
    private List<DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();

    private MonthlyTransactionDetails(int day, List<DailyTransactionDetails> dailyTransactionDetailsList) {
        this.day = day;
        this.dailyTransactionDetailsList = dailyTransactionDetailsList;
    }

    public static MonthlyTransactionDetails from(int day, List<DailyTransactionDetails> dailyTransactionDetails){
        return new MonthlyTransactionDetails(day, dailyTransactionDetails);
    }
    //builder
    //from, of 쓰는 이유가 검증하기 위함
}
