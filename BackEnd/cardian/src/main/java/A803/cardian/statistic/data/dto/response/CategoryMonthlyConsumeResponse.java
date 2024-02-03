package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CategoryMonthlyConsumeResponse {
    private int memberId;
    private List<CategoryMonthlyConsumeWithMonthlyEntireConsume> categoryMonthlyConsumeWithMonthlyEntireConsumeList;

    private CategoryMonthlyConsumeResponse(int memberId, List<CategoryMonthlyConsumeWithMonthlyEntireConsume> categoryMonthlyConsumeWithMonthlyEntireConsumeList){
        this.memberId = memberId;
        this.categoryMonthlyConsumeWithMonthlyEntireConsumeList = categoryMonthlyConsumeWithMonthlyEntireConsumeList;
    }

    public static CategoryMonthlyConsumeResponse toResponse(int month, List<CategoryMonthlyConsumeWithMonthlyEntireConsume> categoryMonthlyConsumeWithMonthlyEntireConsumeList){
        return new CategoryMonthlyConsumeResponse(month, categoryMonthlyConsumeWithMonthlyEntireConsumeList);
    }
}
