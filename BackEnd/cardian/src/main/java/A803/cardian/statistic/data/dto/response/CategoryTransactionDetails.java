package A803.cardian.statistic.data.dto.response;

import A803.cardian.associate.domain.Associate;
import A803.cardian.card.domain.Transaction;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CategoryTransactionDetails {
    private String store; //associate 필요
    private String associateImage;
    private LocalDateTime date;
    private int price;

    public static CategoryTransactionDetails from(Transaction transaction, Associate associate){
        return CategoryTransactionDetails.builder()
                .store(associate.getName())
                .associateImage(associate.getImage())
                .date(transaction.getDate())
                .price(transaction.getPrice())
                .build();
    }
}
