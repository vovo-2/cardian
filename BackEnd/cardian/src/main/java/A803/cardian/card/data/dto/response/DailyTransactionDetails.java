package A803.cardian.card.data.dto.response;

import A803.cardian.associate.domain.Associate;
import A803.cardian.card.domain.BenefitCode;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.Transaction;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class DailyTransactionDetails {
    private Integer transactionId;
    private String store;
    private LocalDateTime date;
    private int price;
    private String associateImage;
    private int discountAmount;
    private BenefitCode benefitCode;

    //associate랑 discountAmount는 service단에서 계산하여 넣어줄 것.
    public static DailyTransactionDetails from(Transaction transaction, Associate associate, int discountAmount){
        //이용한 카드
        Card card = transaction.getMyCard().getCard();

        //어떤 혜택인지 가져오기
        //할인받은 금액 계산 로직
        //카드 + 카테고리 + 혜택 조건으로 계산

        return DailyTransactionDetails.builder()
                .transactionId(transaction.getId())
                .store(transaction.getStore())
                .date(transaction.getDate())
                .price(transaction.getPrice())
                .associateImage(associate.getImage())
                .discountAmount(discountAmount)
                .benefitCode(card.getBenefitCode())
                .build();
    }
}
