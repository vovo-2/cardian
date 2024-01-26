package A803.cardian.card.data.dto.response;

import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MyCard;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MyCardDetails {
    private Integer mycardId;
    private String myCardName;
    private String myCardImage;

    public static MyCardDetails from(MyCard myCard){
        Card card = myCard.getCard();

        return MyCardDetails.builder()
                .mycardId(myCard.getId())
                .myCardName(card.getName())
                .myCardImage(card.getImage())
                .build();
    }
}
