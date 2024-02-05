package A803.cardian.category.data.dto.reponse;

import A803.cardian.card.domain.BenefitCode;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Type;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryCardRecommend {
    private int myCardId;
    private String cardImage;
    private String cardCompany;
    private String cardName;
    private int goal;
    private int consume;
    private Type cardType;
    private BenefitCode benefitCode;
    private int benefitLimitation;
    private int currentBenefit;
    private int discountAmount;
    private String discountSign;
}
