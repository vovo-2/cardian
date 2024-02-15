package A803.cardian.card.data.dto.response;

import A803.cardian.card.domain.*;
import A803.cardian.statistic.domain.AccumulateBenefit;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MyCardInfoDetails {
    private String companyName;
    private String cardName;
    private String cardImage;
    private int goal;
    private int accumulate;
    private Type type;
    private BenefitCode benefitCode;
    private int totalBenefit;

    public static MyCardInfoDetails from(MyCard myCard, int accumulateBenefitAmount, int accumulate){
        Card card = myCard.getCard();
        Company company = card.getCompany();

        return MyCardInfoDetails.builder()
                .companyName(company.getName())
                .cardName(card.getName())
                .cardImage(card.getImage())
                .goal(card.getGoal())
                .accumulate(accumulate) //누적 사용 금액
                .type(card.getType()) //신용, 체크
                .benefitCode(card.getBenefitCode())
                .totalBenefit(accumulateBenefitAmount) //누적 혜택 금액
                .build();
    }
}
