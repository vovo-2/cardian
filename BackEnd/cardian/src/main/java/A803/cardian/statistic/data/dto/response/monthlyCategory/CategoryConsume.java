package A803.cardian.statistic.data.dto.response.monthlyCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
//추가 api
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryConsume {
    private String categoryName;
    private int categoryConsume;

    private CategoryConsume(String categoryName, int categoryConsume){
        this.categoryName = categoryName;
        this.categoryConsume = categoryConsume;
    }

    public static CategoryConsume from(String categoryName, int categoryConsume){
        return new CategoryConsume(categoryName, categoryConsume);
    }
}
