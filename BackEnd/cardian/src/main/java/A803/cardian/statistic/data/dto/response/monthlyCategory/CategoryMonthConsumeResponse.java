package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthConsumeResponse {
    private int memberId;
    private int month;
    private int entireCategoryConsume;
    private List<CategoryConsume> categoryConsumeList;

    private CategoryMonthConsumeResponse(int memberId, int month, int entireCategoryConsume, List<CategoryConsume> categoryConsumeList){
        this.memberId = memberId;
        this.month = month;
        this.entireCategoryConsume = entireCategoryConsume;
        this.categoryConsumeList = categoryConsumeList;
    }

    public static CategoryMonthConsumeResponse toResponse(int memberId, int month, int entireCategoryConsume, List<CategoryConsume> categoryConsumeList){
        return new CategoryMonthConsumeResponse(memberId, month, entireCategoryConsume, categoryConsumeList);
    }
}
