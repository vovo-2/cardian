package A803.cardian.card.data.dto.response;

import A803.cardian.member.domain.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class MyCardListResponse {
    private Integer memberId;
    @JsonProperty("cardList")
    private List<MyCardDetails> myCardDetailList = new ArrayList<>();

    public MyCardListResponse(Integer memberId){
        this.memberId = memberId;
    }

    public static MyCardListResponse toResponse(Member member){
        MyCardListResponse response = new MyCardListResponse(member.getId());
        member.getMyCards().stream()
                .map(MyCardDetails::from)
                .forEach(response.myCardDetailList::add);
        return response;
    }

}
