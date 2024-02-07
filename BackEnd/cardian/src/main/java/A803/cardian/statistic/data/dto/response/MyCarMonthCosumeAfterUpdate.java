package A803.cardian.statistic.data.dto.response;

import A803.cardian.card.domain.MyCard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MyCarMonthCosumeAfterUpdate {
    private MyCard myCard;
    private List<MyCarMonthCosumeAfterUpdateDetails> myCarMonthCosumeAfterUpdateDetailsList;


    private MyCarMonthCosumeAfterUpdate(MyCard myCard, List<MyCarMonthCosumeAfterUpdateDetails> myCarMonthCosumeAfterUpdateDetailsList){
        this.myCard = myCard;
        this.myCarMonthCosumeAfterUpdateDetailsList = myCarMonthCosumeAfterUpdateDetailsList;
    }

    public static MyCarMonthCosumeAfterUpdate from(MyCard myCard, List<MyCarMonthCosumeAfterUpdateDetails> myCarMonthCosumeAfterUpdateDetailsList){
        return new MyCarMonthCosumeAfterUpdate(myCard, myCarMonthCosumeAfterUpdateDetailsList);
    }
}
