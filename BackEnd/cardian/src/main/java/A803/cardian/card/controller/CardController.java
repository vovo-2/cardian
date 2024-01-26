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

//    @GetMapping("/transaction")
//    public ResponseEntity<String> mycardtest{
//        String json = "";
//        return new ResponseEntity<>(json, HttpStatus.OK)
//    }

//    @GetMapping("/test")
//    public ResponseEntity<String> test(){
//        String json = "{\n" +
//                "  \"mycardId\": 123,\n" +
//                "  \"transactionList\": [\n" +
//                "    {\n" +
//                "      \"transactionId\": 1,\n" +
//                "      \"store\": \"가게A\",\n" +
//                "      \"day\": \"Tuesday\",\n" +
//                "      \"date\": \"2022-01-04 11:21:20\",\n" +
//                "      \"price\": 10,\n" +
//                "      \"associateImage\": \"https://i.imgur.com/qh79LY9.jpg\",\n" +
//                "      \"discountAmount\": 11,\n" +
//                "      \"benefitCode\": \"CODE601\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"transactionId\": 2,\n" +
//                "      \"store\": \"가게C\",\n" +
//                "      \"day\": \"Wednesday\",\n" +
//                "      \"date\": \"2022-01-19 05:12:37\",\n" +
//                "      \"price\": 160,\n" +
//                "      \"associateImage\": \"https://i.imgur.com/qh79LY9.jpg\",\n" +
//                "      \"discountAmount\": 18,\n" +
//                "      \"benefitCode\": \"CODE604\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"transactionId\": 3,\n" +
//                "      \"store\": \"가게C\",\n" +
//                "      \"day\": \"Friday\",\n" +
//                "      \"date\": \"2022-01-14 19:37:27\",\n" +
//                "      \"price\": 80,\n" +
//                "      \"associateImage\": \"https://i.imgur.com/w0enIO5.png\",\n" +
//                "      \"discountAmount\": 48,\n" +
//                "      \"benefitCode\": \"CODE562\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "}";
//        return new ResponseEntity<>(json, HttpStatus.OK);
//    }

}
