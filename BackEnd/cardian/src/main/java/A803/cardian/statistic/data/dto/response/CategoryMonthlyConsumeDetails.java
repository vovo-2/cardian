package A803.cardian.statistic.data.dto.response;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CategoryMonthlyConsumeDetails {
    private int monthlyEntireConsumePerCategory;
    private BigDecimal percentOfEntire;

    public static CategoryMonthlyConsumeDetails from(int monthlyEntireConsumePerCategory, BigDecimal percentOfEntire){
        return CategoryMonthlyConsumeDetails.builder()
                .monthlyEntireConsumePerCategory(monthlyEntireConsumePerCategory)
                .percentOfEntire(percentOfEntire)
                .build();
    }
}
