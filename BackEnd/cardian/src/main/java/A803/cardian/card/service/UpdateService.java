package A803.cardian.card.service;


/*
 *   작성자 : 정여민
 *   작성 일시 : 2024.02.02
 *   업데이트 : 2024.02.02
 *   내용 : 카드사에서 가져온 카드 정보 및 거래내역 우리 DB에 업데이트 하는 서비스
 *
 * */

import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.util.WebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class UpdateService {

    @Autowired
    private final MycardRepository mycardRepository;

    @Autowired
    private final WebClientService webClientService;

    // 유저가 회원가입



    //1. 유저가 로그인 -> memberId -> MyCard 조회 -> 카드 아이디가 나옴
    //2. memberId로 카드사에서 유저의 카드 조회 -> Card, MyCard Table update
    //2-1. updateDate : 현재 시간으로 저장 < 필수 이거 없으면 3번이 안 돌아감!
    //
    //3. memberId로 카드사에서 유저의 거래내역 조회
    //-> 이때, Card의 updateDate보다 이전것만 가져오기 (아마 user의 update는 mycard에 다 있는데, 그 중 첫번째 걸 기준으로 하면 될 듯?

    // 내용 : 멤버 아이디를 입력받아, 카드 정보를 업데이트 하는 메서드
    @Transactional
    public List<?> updateCard(Integer memberId){
        // 마지막 업데이트 날짜 가져오기
        String updateDate = updateDate(memberId);

        //1. memberId로 카드사에서 유저의 카드 조회 -> Card, MyCard Table update

        String baseUrl = null;
        String path = null;
        
        // memberId로 카드 내역 가져오기
        
        
        // memberId로 거래 내역 가져오기 
        baseUrl = "http://i10a803.p.ssafy.io:8082";
        path = "/transaction/1/".concat(updateDate);
        webClientService.get(baseUrl, path);

        // 거래 내역 테이블에 저장
        // updateDate update
        



        return null;
    }


    // 업데이트 날짜 반환 메서드
    public String updateDate(Integer memberId){

        List<MyCard> myCards = mycardRepository.findMyCardsByMemberId(memberId);

        log.info(myCards.get(0).getUpdateDate().toString());

        // 카드사 서버에 쿼리하기 위한 형식으로 바꾸기 yyyy-MM-ddHH:mm:ss 형태
        String temp_updateDate = String.valueOf(myCards.get(0).getUpdateDate()).replaceAll(" ", "");
        String [] updateDate01 = temp_updateDate.split("T");
        String updateDate = updateDate01[0].concat(updateDate01[1]).concat(":00");

        log.info(updateDate);

        return updateDate;
    }




}
