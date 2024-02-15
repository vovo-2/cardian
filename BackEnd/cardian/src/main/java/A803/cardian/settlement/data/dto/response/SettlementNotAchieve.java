package A803.cardian.settlement.data.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementNotAchieve {
    private int annualConsume;
    private int settlementStandard;
    private int annualCheckConsume;
    private int annualCreditConsume;
}
