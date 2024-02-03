package A803.cardian.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

/*
*   작성자 : 정여민
*   작성일시 : 2024.02.02
*   업데이트 : 2024.02.02
*   내용 : 외부 API 가져오기 위한 Class
* */


@Service
@Slf4j
public class WebClientService {

    public void get(String baseUrl, String path){
        // webClient 기본 설정
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        // api 요청
        Map<String, Object> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .build())
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        // 결과 확인
        log.info(response.toString());

    }




}
