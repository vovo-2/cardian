package A803.cardian.statistic.data.dto.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CategoryMonthlyConsume {
    private int monthlyEntireConsume;
    private int monthlyEntireConsumePerCategory;
    private int percentOfEntire;

    public CategoryMonthlyConsume from(int monthlyEntireConsume, int monthlyEntireConsumePerCategory, int percentOfEntire){
        return CategoryMonthlyConsume.builder()
                .monthlyEntireConsume(monthlyEntireConsume)
                .monthlyEntireConsumePerCategory(monthlyEntireConsumePerCategory)
                .percentOfEntire(percentOfEntire)
                .build();
    }
}
