package A803.cardian.statistic.data.dto.response.category;

import A803.cardian.associate.domain.Associate;
import A803.cardian.card.domain.Transaction;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CategoryDayTransactionDetails {
    private String store;
    private int price;
    private LocalDateTime date;
    private String associateImage;

    public static CategoryDayTransactionDetails from(Transaction transaction, Associate associate){
        return CategoryDayTransactionDetails.builder()
                .store(associate.getName())
                .price(transaction.getPrice())
                .date(transaction.getDate())
                .associateImage(associate.getImage())
                .build();
    }
}
