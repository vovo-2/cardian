package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//월별
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthConsumeDetails {
    private int month;
    private int consumeAfterUpdate;

    private CategoryMonthConsumeDetails(int month, int consumeAfterUpdate){
        this.month= month;
        this.consumeAfterUpdate = consumeAfterUpdate;
    }

    public static CategoryMonthConsumeDetails from(int month, int consumeAfterUpdate){
        return new CategoryMonthConsumeDetails(month, consumeAfterUpdate);
    }
}
