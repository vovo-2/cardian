package A803.cardian.card.controller;

import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
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

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/{mycard_id}/transaction")
    public ResponseEntity<String> getCardsTransaction(@PathVariable("mycard_id") Integer cardId){
        String json="{\n" +
                "          \"mycardId\": 1,\n" +
                "          \"month\" : 12,\n" +
                "          \"transactionList\":[\n" +
                "               {\n" +
                "                    \"day\": \"String\",\n" +
                "                    \"dayTransactionList\":[\n" +
                "                         {\n" +
                "                              \"transactionId\": 3,\n" +
                "                              \"store\": \"메가커피\",\n" +
                "                              \"date\": \"2023-12-12  08:58:00\",\n" +
                "                              \"price\": 4000,\n" +
                "                              \"associateImage\": \"https://imgur.com/bsSayy3\",\n" +
                "                              \"discountAmount\": 500,\n" +
                "                              \"benefitCode\": \"할인\"\n" +
                "                         },\n" +
                "  {\n" +
                "                              \"transactionId\": 2,\n" +
                "                              \"store\": \"배달의 민족\",\n" +
                "                              \"date\": \"2023-12-11  16:58:00\",\n" +
                "                              \"price\": 14000,\n" +
                "                              \"associateImage\": \"https://imgur.com/FE9mc5c\",\n" +
                "                              \"discountAmount\": 0,\n" +
                "                              \"benefitCode\": \"할인\"\n" +
                "                         },\n" +
                "  {\n" +
                "                              \"transactionId\": 1,\n" +
                "                              \"store\": \"박승철헤어스튜디오\",\n" +
                "                              \"date\": \"2023-12-08  13:58:00\",\n" +
                "                              \"price\": 25000,\n" +
                "                              \"associateImage\": \"https://imgur.com/YyXalCX\",\n" +
                "                              \"discountAmount\": 0,\n" +
                "                              \"benefitCode\": \"할인\"\n" +
                "                         }\n" +
                "                    ]\n" +
                "               }\n" +
                "          ],\n" +
                "}";
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @Operation(summary = "내 카드 혜택 조회", description = "내 카드에서 혜택 탭을 선택하면 해당 카드의 혜택 리스트를 불러오는 API입니다.")
    @GetMapping("/{mycard_id}/benefit")
    public ResponseEntity<List<CardCategoryBenefitResponses>> getMeCardBenefit(@PathVariable("mycard_id") Integer mycardId){
        List<CardCategoryBenefitResponses> benefitList = new ArrayList<>();
        benefitList = cardService.findMyCardBenefit(mycardId);
        if(benefitList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // ErrorResponse를 JSON으로 변환
        }
        return ResponseEntity.status(HttpStatus.OK).body(benefitList);
    }



}
