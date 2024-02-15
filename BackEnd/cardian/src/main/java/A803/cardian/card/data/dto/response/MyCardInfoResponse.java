package A803.cardian.card.data.dto.response;

import A803.cardian.card.domain.MyCard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MyCardInfoResponse {
    private int myCardId;
    private MyCardInfoDetails myCardInfoDetails;

    private MyCardInfoResponse(int myCardId, MyCardInfoDetails myCardInfoDetails){
        this.myCardId = myCardId;
        this.myCardInfoDetails = myCardInfoDetails;
    }

    public static MyCardInfoResponse toResponse(MyCard myCard, MyCardInfoDetails myCardInfoDetails){
        MyCardInfoResponse response = new MyCardInfoResponse(myCard.getId(), myCardInfoDetails);
        return response;
    }
}
