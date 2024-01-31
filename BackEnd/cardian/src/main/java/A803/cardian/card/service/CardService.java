package A803.cardian.card.service;

import A803.cardian.card.data.dto.response.CardCategoryBenefitResponses;
import A803.cardian.card.data.dto.response.MyCardInfoDetails;
import A803.cardian.card.data.dto.response.MyCardInfoResponse;
import A803.cardian.card.data.dto.response.MyCardListResponse;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MyCardRepository;
import A803.cardian.member.domain.Member;
import A803.cardian.member.exception.MemberErrorCode;
import A803.cardian.member.exception.MemberException;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.domain.repository.AccumulateBenefitRepository;
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
    private final MyCardRepository myCardRepository;
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
    public List<CardCategoryBenefitResponses> findMyCardBenefit(Integer cardId){
        List<CardCategoryBenefitResponses> myCardBenefitList = myCardBenefitRepository.findProjectBenefitCodeByCardId(cardId);
        return myCardBenefitList;
    }

    //accumulateBenefit이랑 accumulate 계산해서 넣어주기
    public MyCardInfoResponse getMyCardInfo(int myCardId) {
        MyCard myCard = myCardRepository.findById(myCardId)
                .orElseThrow(() ->
                        new RuntimeException());

        Card card = myCard.getCard();
        LocalDate localDate = LocalDate.now();
        localDate = localDate.withYear(2023);

        /*
        public static MyCardInfoDetails from(MyCard myCard, int accumulateBenefitAmount, int accumulate)
         */
        //누적 혜택 가져오기
        Optional<AccumulateBenefit> accumulateBenefit = accumulateBenefitRepository.findAccumulateBenefitByCardIdAndCategoryCode(myCard.getId(), card.getBenefitCode().getValue());
        //누적 혜택 금액 가져오기
        int accumulateBenefitAmount = 0;
        if(accumulateBenefit.isPresent()){
            accumulateBenefitAmount = accumulateBenefit.get().getBenefitAmount();
        }
        //당월 사용금액 가져오기
        int totalaccumulate = transactionService.getMonthlyAccumulate(myCard.getId(), localDate);

        return MyCardInfoResponse.toResponse(myCard, MyCardInfoDetails.from(myCard, accumulateBenefitAmount, totalaccumulate));
    }

}
