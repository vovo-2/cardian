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
public class CategoryCardRecommend implements Comparable<CategoryCardRecommend>{
    private int myCardId;
    private String cardImage;
    private String cardCompany;
    private String cardName;
    private String associateName;
    private int goal;
    private int consume;
    private boolean thisMonthAchieve;
    private Type cardType;
    private BenefitCode benefitCode;
    private int benefitLimitation;
    private int currentBenefit;
    private boolean benefitRemain;
    private int discountAmount;
    private String discountSign;
    private boolean goalAchieve;

    @Override
    public int compareTo(CategoryCardRecommend otherCard) {
        if (this.goalAchieve && otherCard.goalAchieve) {
            if (this.benefitRemain && otherCard.benefitRemain) {
                return Integer.compare(otherCard.discountAmount, this.discountAmount);
            } else if (this.benefitRemain) {
                return -1;
            } else if (otherCard.benefitRemain) {
                return 1;
            }
        } else if (this.goalAchieve) {
            return -1;
        } else if (otherCard.goalAchieve) {
            return 1;
        }

        // goalAchieve가 false인 경우 discountAmount로 정렬
        return Integer.compare(otherCard.discountAmount, this.discountAmount);
    }
}
