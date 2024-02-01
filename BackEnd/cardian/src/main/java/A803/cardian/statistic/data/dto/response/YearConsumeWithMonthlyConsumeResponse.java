package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class YearConsumeWithMonthlyConsumeResponse {
    private int memberId;
    private YearConsumeAmount yearConsumeAmount;

    private YearConsumeWithMonthlyConsumeResponse(int memberId, YearConsumeAmount yearConsumeAmount){
        this.memberId = memberId;
        this.yearConsumeAmount = yearConsumeAmount;
    }

    public static YearConsumeWithMonthlyConsumeResponse toResponse(int memberId, YearConsumeAmount yearConsumeAmount){
        return new YearConsumeWithMonthlyConsumeResponse(memberId, yearConsumeAmount);
    }

}
