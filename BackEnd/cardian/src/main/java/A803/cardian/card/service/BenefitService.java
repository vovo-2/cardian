package A803.cardian.card.service;


import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.benefit.data.dto.BenefitStore;
import A803.cardian.benefit.domain.CardCategoryMapping;
import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import A803.cardian.benefit.repository.CardCategoryMappingRepository;
import A803.cardian.benefit.repository.CategoryBenefitRepository;
import A803.cardian.benefit.repository.ExceptionBenefitRepository;
import A803.cardian.benefit.serivce.CategoryBenefitService;
import A803.cardian.benefit.serivce.ExceptionBenefitService;
import A803.cardian.card.data.dto.response.CardBenefitCategoryResponse;
import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MycardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
*   작성자 : 정여민
*   작성 일시 : 2024.01.31
*   업데이트 : 2024.01.31
*
* */

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class BenefitService {

    @Autowired
    private final MycardRepository myCardRepository;

    @Autowired
    private final MyCardBenefitRepository myCardBenefitRepository;

    @Autowired
    private final CardRepository cardRepository;

    @Autowired
    private final ExceptionBenefitRepository exceptionBenefitRepository;

    @Autowired
    private final AssociateRepository associateRepository;

    @Autowired
    private final CategoryBenefitRepository categoryBenefitRepository;

    @Autowired
    private final CardCategoryMappingRepository cardCategoryMappingRepository;

    private final ExceptionBenefitService exceptionBenefitService;
    private final CategoryBenefitService categoryBenefitService;


    // 내 카드의 혜택 조회 - 카드의 혜택을 List로 반환
    // 작성자 : 정여민
    // 작성일시 : 2024.01.30
    @Transactional
    public List<CardCategoryBenefitResponses> findMyCardBenefit(Integer cardId){
        List<CardCategoryBenefitResponses> myCardBenefitList = myCardBenefitRepository.findProjectBenefitCodeByCardId(cardId);
        return myCardBenefitList;
    }

    /*
    *   작성자 : 정여민
    *   작성 일시 : 2024.01.31
    *   업데이트 : 2024.01.31
    * */
    // 내 카드의 혜택 조회 - 카테고리별 혜택 List로 반환
    // 컨트롤러에서 부를 것
    @Transactional
    public CardBenefitCategoryResponse getMyCardBenefitStoresOfCategory(Integer mycardId, String categoryCode){

        // 1. 내 카드 조회 -> 카드 아이디 가져오기
        MyCard myCard = myCardRepository.findById(mycardId).orElseThrow(()->
            // 추후에 myCardException 만들기
            new RuntimeException());

        // 2. 카드 조회 -> 카드사 아이디
        Card card = cardRepository.findById(myCard.getCard().getId()).orElseThrow(()->
                // 추후 CardException 만들기
                new RuntimeException());

        Integer cardId = card.getId();
        Integer companyId = card.getCompany().getId();


        /**************************예외 혜택**********************************/

        log.debug("**************************예외 혜택**********************************");
        log.debug("cardId: " + cardId+ "\tcompanyId: " + companyId + "\tCategoryCode: " + categoryCode);

       // 3. 카드 아이디, 카드사 아이디, 카테고리 코드 -> 예외 혜택 리스트 조회
        // : 상호명, 할인금액, 부호 가져오기 <- Map<"exceptionBenefitList", List>
        // 예외 혜택이 있는지 확인
        Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitService.getExceptionBenefit(cardId, companyId, categoryCode);

        BenefitStore exceptionBenefitStore = null;

        // 예외 혜택이 있으면
        if(exceptionBenefit.isPresent()){
            // exceptionBenefit으로 제휴사 이름 가져오기
            Optional<Associate> exceptionAssociate = associateRepository.findById(exceptionBenefit.get().getAssociateId());

            // 예외 혜택 Dto
            exceptionBenefitStore = BenefitStore.from(exceptionBenefit.get(), exceptionAssociate.get().getName());
        }else{
            // 예외 혜택 부분 없으면 빈 값
            exceptionBenefitStore = new BenefitStore("", 0, "" );

        }
        // 예외 혜택이 있거나 없거나 실행되어야 할 것
        // 1. 카드 아이디, 카테고리 코드 -> 카테고리 혜택 => 해당 카테고리의 카테고리혜택 아이디, 할인크기, 기호 가져오기
        CategoryBenefit categoryBenefit = categoryBenefitRepository.findCategoryBenefitByCardIdAndCategoryCode(cardId, categoryCode);

        List<BenefitStore> storeList = new ArrayList<>();

        // 2. 카드 카테고리 매핑 테이블에 가서 제휴사 아이디 가져오기 -> 카드 아이디, 카테고리 코드, 카테고리 혜택 아이디 사용

            List<CardCategoryMapping> cardCategoryMapping = cardCategoryMappingRepository.findCardCategoryMappingsByCardIdAndCategoryCodeAndCategoryBenefit_Id(cardId, categoryCode, categoryBenefit.getId());
        for (CardCategoryMapping categoryMapping : cardCategoryMapping) {
            // 3.  상호명 가져오기 -> 제휴사 아이디로 조회
            Optional<Associate> associate = associateRepository.findById(categoryMapping.getAssociate().getId());
            // 제휴사가 존재하면
            if(associate.isPresent()){
                storeList.add(BenefitStore.builder()
                        .storeName(associate.get().getName())
                        .discountAmount(categoryBenefit.getDiscountAmount())
                        .sign(categoryBenefit.getSign())
                        .build());
            }else{
                storeList.add(BenefitStore.builder()
                        .storeName("")
                        .discountAmount(0)
                        .sign("")
                        .build());
            }
        }

        return CardBenefitCategoryResponse.toResponse(exceptionBenefitStore, storeList);

    }





}
