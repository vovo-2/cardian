package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class YearConsumeAmount {
    private int yearConsumeAmount;
    private MonthlyConsumeAmount monthlyConsumeAmount;

    private YearConsumeAmount(int yearConsumeAmount, MonthlyConsumeAmount monthlyConsumeAmount){
        this.yearConsumeAmount = yearConsumeAmount;
        this.monthlyConsumeAmount = monthlyConsumeAmount;
    }

    public static YearConsumeAmount from(int yearConsumeAmount, MonthlyConsumeAmount monthlyConsumeAmount){
        return new YearConsumeAmount(yearConsumeAmount, monthlyConsumeAmount);
    }
}
