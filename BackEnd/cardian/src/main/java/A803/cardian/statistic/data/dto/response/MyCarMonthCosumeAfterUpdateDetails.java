package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MyCarMonthCosumeAfterUpdateDetails {
    private int month;
    private int consumeAfterUpdate;

    private MyCarMonthCosumeAfterUpdateDetails(int month, int consumeAfterUpdate){
        this.month = month;
        this.consumeAfterUpdate = consumeAfterUpdate;
    }

    public static MyCarMonthCosumeAfterUpdateDetails from(int month, int consumeAfterUpdate){
        return new MyCarMonthCosumeAfterUpdateDetails(month, consumeAfterUpdate);
    }
}
