package A803.cardian.reocommendation.data.dto.response;

import A803.cardian.card.data.dto.response.CardBenefitCategoryResponse;
import A803.cardian.card.domain.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CardRecommendationResponse {
    private int cardId;
    private String companyName;
    private String cardName;
    private String cardImage;
    private BenefitCode benefitCode;
    private Type type;
    private List<CardBenefitDetails> cardBenefitDetailsList;
    private int recievedBenefitAmount;
    private int maxBenefitAmount;

    private CardRecommendationResponse(Card card, List<CardBenefitDetails> cardBenefitDetailsList, int recievedBenefitAmount, int maxBenefitAmount){
        this.cardId = card.getId();
        this.companyName = card.getCompany().getName();
        this.cardName = card.getName();
        this.cardImage = card.getImage();
        this.benefitCode = card.getBenefitCode();
        this.type = card.getType();
        this.cardBenefitDetailsList = cardBenefitDetailsList;
        this.recievedBenefitAmount = recievedBenefitAmount;
        this.maxBenefitAmount = maxBenefitAmount;
    }

    public static CardRecommendationResponse toResponse(Card card, List<CardBenefitDetails> cardBenefitDetailsList, int recievedBenefitAmount, int maxBenefitAmount){
        return new CardRecommendationResponse(card, cardBenefitDetailsList, recievedBenefitAmount, maxBenefitAmount);
    }
}
