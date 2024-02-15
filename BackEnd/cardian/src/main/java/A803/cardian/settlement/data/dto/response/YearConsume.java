package A803.cardian.settlement.data.dto.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class YearConsume {
    private int yearCheckConsume;
    private int yearCreditConsume;
}
