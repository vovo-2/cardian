package A803.cardian.statistic.data.dto.response;

import A803.cardian.card.domain.MyCard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MyCardMonthCosumeAfterUpdate {
    private MyCard myCard;
    private List<MyCardMonthCosumeAfterUpdateDetails> myCardMonthCosumeAfterUpdateDetailsList;


    private MyCardMonthCosumeAfterUpdate(MyCard myCard, List<MyCardMonthCosumeAfterUpdateDetails> myCardMonthCosumeAfterUpdateDetailsList){
        this.myCard = myCard;
        this.myCardMonthCosumeAfterUpdateDetailsList = myCardMonthCosumeAfterUpdateDetailsList;
    }

    public static MyCardMonthCosumeAfterUpdate from(MyCard myCard, List<MyCardMonthCosumeAfterUpdateDetails> myCardMonthCosumeAfterUpdateDetailsList){
        return new MyCardMonthCosumeAfterUpdate(myCard, myCardMonthCosumeAfterUpdateDetailsList);
    }
}
