package A803.cardian.card.controller;

import A803.cardian.card.data.dto.response.MyCardListResponse;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "카드 컨트롤러", description = "카드 관련 정보")
@RequestMapping("/card")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class CardController {

    @Autowired
    private final CardService cardService;

//    @ApiResponse({
//            @ApiResponse(responseCode = "200", description = "내 카드 조회 성공"),
//            @ApiResponse(responseCode = "400", description = "내 카드 조회 실패(MEMBER_02)")
//    })
    @Operation(summary = "내 카드 조회", description = "홈 화면에 노출할 내가 가진 카드 리스트를 불러오는 API입니다.")
    @GetMapping("/{member_id}")
    public ResponseEntity<MyCardListResponse> getMyCards(@PathVariable("member_id") Integer memberId){
        MyCardListResponse response = cardService.findMyCards(memberId);
        return ResponseEntity.ok(response);
    }
}
