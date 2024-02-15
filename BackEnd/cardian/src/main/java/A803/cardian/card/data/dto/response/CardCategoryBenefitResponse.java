package A803.cardian.card.data.dto.response;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class CardCategoryBenefitResponse {

    private int cardId;
    private String categoryCode;
    private String iconImage;
    private int discountAmount;
    private int categorybenefitId;
    private String sign;
    private String name;



}
