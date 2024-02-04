package A803.cardian.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*   작성자 : 정여민
*   작성일시 : 2024.02.02
*   업데이트 : 2024.02.04
*   내용 : 외부 API 가져오기 위한 Class
*   업데이트 : buffer 설정 변경, JSON 객체 리턴하도록 변경
* */


@Service
@Slf4j
public class WebClientService {

    public Map<String, Object> get(String baseUrl, String path){

        // buffer 설정 max로 변경
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
                .build();

        // webClient 기본 설정
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .exchangeStrategies(exchangeStrategies)
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

        return response;
    }

    public List<Map> getJSONArray(String baseUrl, String path){

        // buffer 설정 max로 변경
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)) // to unlimited memory size
                .build();

        // webClient 기본 설정
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .exchangeStrategies(exchangeStrategies)
                .build();
        // api 요청
        List<Map> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .build())
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        // 결과 확인
        log.info(response.toString());

        return  response;
    }




}
