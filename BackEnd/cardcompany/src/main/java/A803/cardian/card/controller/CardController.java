package A803.cardian.card.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Tag(name = "카드 컨트롤러", description = "로그인 및 회원 가입")
@RequestMapping("/card")
@RequiredArgsConstructor
@RestController
public class CardController {
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        String json = "{\n" +
                "  \"mycardId\": 123,\n" +
                "  \"transactionList\": [\n" +
                "    {\n" +
                "      \"transactionId\": 1,\n" +
                "      \"store\": \"가게A\",\n" +
                "      \"day\": \"Tuesday\",\n" +
                "      \"date\": \"2022-01-04 11:21:20\",\n" +
                "      \"price\": 10,\n" +
                "      \"associateImage\": \"https://i.imgur.com/qh79LY9.jpg\",\n" +
                "      \"discountAmount\": 11,\n" +
                "      \"benefitCode\": \"CODE601\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"transactionId\": 2,\n" +
                "      \"store\": \"가게C\",\n" +
                "      \"day\": \"Wednesday\",\n" +
                "      \"date\": \"2022-01-19 05:12:37\",\n" +
                "      \"price\": 160,\n" +
                "      \"associateImage\": \"https://i.imgur.com/qh79LY9.jpg\",\n" +
                "      \"discountAmount\": 18,\n" +
                "      \"benefitCode\": \"CODE604\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"transactionId\": 3,\n" +
                "      \"store\": \"가게C\",\n" +
                "      \"day\": \"Friday\",\n" +
                "      \"date\": \"2022-01-14 19:37:27\",\n" +
                "      \"price\": 80,\n" +
                "      \"associateImage\": \"https://i.imgur.com/w0enIO5.png\",\n" +
                "      \"discountAmount\": 48,\n" +
                "      \"benefitCode\": \"CODE562\"\n" +
                "    }\n" +
                "  ],\n" +
                "}";
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
