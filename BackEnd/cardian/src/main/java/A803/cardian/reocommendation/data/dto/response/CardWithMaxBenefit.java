package A803.cardian.reocommendation.data.dto.response;

import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MyCard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CardWithMaxBenefit {
    private MyCard myCard;
    private int maxBenefit;

    private CardWithMaxBenefit(MyCard myCard, int maxBenefit){
        this.myCard = myCard;
        this.maxBenefit = maxBenefit;
    }

    public static CardWithMaxBenefit from(MyCard myCard, int maxBenefit){
        return new CardWithMaxBenefit(myCard, maxBenefit);
    }
}
