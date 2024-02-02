package A803.cardian.settlement.data.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettlementAchieve {
    private int annualCheckConsume;
    private int annualCreditConsume;
    private int maxSettlement;
    private int mySettlement;
}
