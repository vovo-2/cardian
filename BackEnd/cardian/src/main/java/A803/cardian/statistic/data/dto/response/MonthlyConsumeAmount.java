package A803.cardian.statistic.data.dto.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MonthlyConsumeAmount {
    private int january;
    private int february;
    private int march;
    private int april;
    private int may;
    private int june;
    private int july;
    private int august;
    private int september;
    private int october;
    private int november;
    private int december;

    @Builder
    public static MonthlyConsumeAmount from(int january, int february, int march, int april, int may,
                                 int june, int july, int august, int september,
                                 int october,int november,int december){

        return MonthlyConsumeAmount.builder()
                .january(january)
                .february(february)
                .march(march)
                .april(april)
                .may(may)
                .june(june)
                .july(july)
                .august(august)
                .september(september)
                .october(october)
                .november(november)
                .december(december)
                .build();
    }

}
