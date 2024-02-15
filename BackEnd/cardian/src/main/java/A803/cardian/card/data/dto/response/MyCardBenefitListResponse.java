package A803.cardian.card.data.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MyCardBenefitListResponse {

    // 카드 아이디
    private Integer cardId;

    // 카테고리 코드
    private String categoryCode;

    // 카테고리 아이콘 주소
    private String iconImage;

    // 혜택 양
    private int discountAmount;

    // 혜택 부호 + , %
    private String sign;

    // 혜택 코드
    private String categorybenefitId;

    // 혜택명
    private String name;


    public MyCardBenefitListResponse(Integer cardId){



    }


    // Dto to Entity
//    public static MyCardBenefitListResponse toResponse(Integer cardId){
//        MyCardBenefitListResponse response = new MyCardBenefitListResponse(cardId);
//
//
//
//
//    }



}
