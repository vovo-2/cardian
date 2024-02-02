package A803.cardian.statistic.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CategoryMonthlyConsumeResponse {
    private String category;
    private List<CategoryMonthlyConsumeWithMonth> categoryMonthlyConsumeWithMonthList;

    private CategoryMonthlyConsumeResponse(String category, List<CategoryMonthlyConsumeWithMonth> categoryMonthlyConsumeWithMonthList){
        this.category =category;
        this.categoryMonthlyConsumeWithMonthList = categoryMonthlyConsumeWithMonthList;
    }

    public static CategoryMonthlyConsumeResponse toResponse(String category, List<CategoryMonthlyConsumeWithMonth> categoryMonthlyConsumeWithMonthList){
        return new CategoryMonthlyConsumeResponse(category, categoryMonthlyConsumeWithMonthList);
    }
}
