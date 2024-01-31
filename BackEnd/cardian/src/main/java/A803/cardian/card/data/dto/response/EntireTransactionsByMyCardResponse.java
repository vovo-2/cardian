package A803.cardian.card.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class EntireTransactionsByMyCardResponse {
//    @JsonProperty("myCardId")
    private int myCardId;

//    @JsonProperty("TransactionDetailsList")
    private List<YearTransactionDetails> yearTransactionDetailsList;

    private EntireTransactionsByMyCardResponse(int myCardId, List<YearTransactionDetails> yearTransactionDetailsList){
        this.myCardId = myCardId;
        this.yearTransactionDetailsList = yearTransactionDetailsList;
    }

    public static EntireTransactionsByMyCardResponse toResponse(int myCardId, List<YearTransactionDetails> yearTransactionDetailsList){
        return new EntireTransactionsByMyCardResponse(myCardId, yearTransactionDetailsList);
    }
}
