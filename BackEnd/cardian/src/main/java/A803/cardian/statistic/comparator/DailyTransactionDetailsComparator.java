package A803.cardian.statistic.comparator;

import A803.cardian.statistic.data.dto.response.monthlyCategory.DailyTransactionDetails;

import java.util.Comparator;

public class DailyTransactionDetailsComparator implements Comparator<DailyTransactionDetails> {
    @Override
    public int compare(DailyTransactionDetails t1, DailyTransactionDetails t2){
        return t1.getDate().compareTo(t2.getDate());
    }
}
