package A803.cardian.card.service;

import A803.cardian.Exception.ErrorCode;
import A803.cardian.Exception.ErrorException;
import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
import A803.cardian.card.data.dto.response.MyCardInfoDetails;
import A803.cardian.card.data.dto.response.MyCardInfoResponse;
import A803.cardian.card.data.dto.response.MyCardListResponse;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.member.domain.Member;
import A803.cardian.member.exception.MemberErrorCode;
import A803.cardian.member.exception.MemberException;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.repository.AccumulateBenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CardService {
    private final CardRepository cardRepository;
    private final MemberRepository memberRepository;
    private final MycardRepository myCardRepository;
    private final MyCardBenefitRepository myCardBenefitRepository;
    private final AccumulateBenefitRepository accumulateBenefitRepository;
    private final TransactionService transactionService;

    //내 카드 전체 조회
    public MyCardListResponse findMyCards(Integer memberId) {
        /*
        member가 실제 존재하는지 확인하는 로직 필요?
         */
        Member member = (Member) memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new MemberException(MemberErrorCode.NO_MEMBER));
        return MyCardListResponse.toResponse(member);
    }

    // 내 카드의 혜택 조회 - 카드의 혜택을 List로 반환
    // 작성자 : 정여민
    // 작성일시 : 2024.01.30
//    public List<CardCategoryBenefitResponses> findMyCardBenefit(Integer cardId){
//        List<CardCategoryBenefitResponses> myCardBenefitList = myCardBenefitRepository.findProjectBenefitCodeByCardId(cardId);
//        return myCardBenefitList;
//    }

    //accumulateBenefit이랑 accumulate 계산해서 넣어주기
    public MyCardInfoResponse getMyCardInfo(int myCardId) {
        MyCard myCard = myCardRepository.findById(myCardId)
                .orElseThrow(() ->
                        new ErrorException(ErrorCode.NO_CARD));

        Card card = myCard.getCard();
//        LocalDate localDate = LocalDate.now();
        LocalDate now = MonthDay.DECEMBER.toLocalDate();

        /*
        public static MyCardInfoDetails from(MyCard myCard, int accumulateBenefitAmount, int accumulate)
         */
        //누적 혜택 가져오기 - 로직
//        Optional<AccumulateBenefit> accumulateBenefit = accumulateBenefitRepository.findAccumulateBenefitByMyCardIdAndCategoryCode(myCard.getId(), card.getBenefitCode().getValue());
//        int accumulateBenefitAmount = 0;
//        if(accumulateBenefit.isPresent()){
//            accumulateBenefitAmount = accumulateBenefit.get().getBenefitAmount();
//        }
        //누적 혜택 가져오기 - 로직

        //누적 혜택 가져오기 - 테이블
        //1. 카드별 당월 카테고리별 누적 혜택 금액 객체를 카드아이디로 리스트로 가져오기
        int accumulateBenefitAmount = 0;
        List<AccumulateBenefit> accumulateBenefitList = accumulateBenefitRepository.findAccumulateBenefitsByMyCardId(myCardId);
        for (AccumulateBenefit accumulateBenefit : accumulateBenefitList) {
            //모든 카테고리별 누적혜택 더해주기
            accumulateBenefitAmount += accumulateBenefit.getBenefitAmount();
        }
        //누적 혜택 가져오기 - 테이블

        //당월 사용금액 가져오기 - 로직
        int totalaccumulate = transactionService.getMonthlyAccumulate(myCard.getId(), now);

        return MyCardInfoResponse.toResponse(myCard, MyCardInfoDetails.from(myCard, accumulateBenefitAmount, totalaccumulate));
    }
    public int getCardId(Integer myCardId){
        Optional<MyCard> myCard = myCardRepository.findById(myCardId);
        Optional<Card> card = cardRepository.findById(myCard.get().getCard().getId());
        Integer cardId=card.get().getId();
        return cardId;
    }

}
