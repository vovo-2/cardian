package A803.cardian.card.data.dto.response;

import A803.cardian.card.domain.BenefitCode;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MyCardInfoDetails {
    private int mycardId;
    private String companyName;
    private String cardName;
    private String cardImage;
    private int goal;
    private int accumulate;
    private BenefitCode benefitCode;
    private int totalBenefit;
}
