package A803.cardian.statistic.data.dto.response;

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
