package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MyCardMonthCosumeAfterUpdateDetails {
    private int month;
    private int consumeAfterUpdate;

    private MyCardMonthCosumeAfterUpdateDetails(int month, int consumeAfterUpdate){
        this.month = month;
        this.consumeAfterUpdate = consumeAfterUpdate;
    }

    public static MyCardMonthCosumeAfterUpdateDetails from(int month, int consumeAfterUpdate){
        return new MyCardMonthCosumeAfterUpdateDetails(month, consumeAfterUpdate);
    }
}
