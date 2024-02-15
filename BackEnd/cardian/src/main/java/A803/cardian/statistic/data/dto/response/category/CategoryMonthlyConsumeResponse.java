package A803.cardian.statistic.data.dto.response.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CategoryMonthlyConsumeResponse {
    private int memberId;
    private List<CategoryMonthlyConsume> categoryMonthlyConsumeList;

    private CategoryMonthlyConsumeResponse(int memberId, List<CategoryMonthlyConsume> categoryMonthlyConsumeList){
        this.memberId = memberId;
        this.categoryMonthlyConsumeList = categoryMonthlyConsumeList;
    }

    public static CategoryMonthlyConsumeResponse toResponse(int month, List<CategoryMonthlyConsume> categoryMonthlyConsumeList){
        return new CategoryMonthlyConsumeResponse(month, categoryMonthlyConsumeList);
    }
}
