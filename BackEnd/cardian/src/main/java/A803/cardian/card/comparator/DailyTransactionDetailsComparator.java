package A803.cardian.card.comparator;

import A803.cardian.card.data.dto.response.DailyTransactionDetails;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Comparator;

public class DailyTransactionDetailsComparator implements Comparator<DailyTransactionDetails> {
    @Override
    public int compare(DailyTransactionDetails t1, DailyTransactionDetails t2){
        return t1.getDate().compareTo(t2.getDate());
    }
}
