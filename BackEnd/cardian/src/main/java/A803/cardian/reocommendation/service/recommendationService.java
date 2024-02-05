package A803.cardian.reocommendation.service;

import A803.cardian.associate.domain.Associate;
import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import A803.cardian.benefit.repository.CategoryBenefitRepository;
import A803.cardian.benefit.repository.ExceptionBenefitRepository;
import A803.cardian.card.domain.*;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.card.service.TransactionService;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.SubCommonCodeRepository;
import A803.cardian.goal.repository.GoalRepository;
import A803.cardian.reocommendation.data.dto.response.CardBenefitDetails;
import A803.cardian.reocommendation.data.dto.response.CardRecommendationResponse;
import A803.cardian.reocommendation.data.dto.response.CardWithMaxBenefit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class recommendationService {
    private final TransactionRepository transactionRepository;
    private final MycardRepository mycardRepository;
    private final ExceptionBenefitRepository exceptionBenefitRepository;
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final CategoryBenefitRepository categoryBenefitRepository;
    private final GoalRepository goalRepository;
    private final TransactionService transactionService;

    //카테고리 별 이번 달 받은 혜택

    //할인금액 계산
    //예외혜택
    public int calculateDiscountAmountWithExceptionBenefit(Transaction transaction, ExceptionBenefit exceptionBenefit) {
        Card card = transaction.getMyCard().getCard();
        /*
       추후에 accumulateBenefit 데이터 넣으면 수정하기
         */
        int benefitAmount = 0;
        int discountLimit = exceptionBenefit.getDiscountLimit(); //혜택 한도

        //1. 해당 카테고리의 누적혜택금액이 한도를 채웠으면 혜택 0원
        if(benefitAmount >= discountLimit){
            return 0;
        }
        //2. 넘지 않았으면 계산
        else {
            int price = transaction.getPrice(); //소비금액
            int discountLine = exceptionBenefit.getDiscountLine(); //혜택기준
            int discountAmount = exceptionBenefit.getDiscountAmount(); //혜택크기
            //할인형일 때
            if(card.getBenefitCode().equals(BenefitCode.DISCOUNT)){
                return transactionService.getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, exceptionBenefit.getSign());
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    int result = transactionService.getDiscountAmountUsingSign(price, discountAmount, exceptionBenefit.getSign());
                    //결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                    //넘거나 같으면
                    if(benefitAmount + result >= discountLimit){
                        // 남은 한도만큼만 리턴
                        return discountLimit - benefitAmount;
                    } else{ //넘지 않으면 계산된 혜택 리턴
                        return result;
                    }
                }
                //넘지 않았으면
                else {
                    return 0;
                }
            }
        }
    }

    //할인금액 계산
    //카테고리혜택
    public int calculateDiscountAmountWithCategoryBenefit(Transaction transaction, CategoryBenefit categoryBenefit) {
        Card card = transaction.getMyCard().getCard();
//        AccumulateBenefit accumulateBenefit = getAccumulateBenefit(transaction)
//                .orElseThrow(() ->
//                        //추후
//                        new RuntimeException());
//        int benefitAmount = accumulateBenefit.getBenefitAmount(); //현재 누적 혜택 금액
        /*
       추후에 accumulateBenefit 데이터 넣으면 수정하기
         */
        int benefitAmount = 0;
        int discountLimit = categoryBenefit.getDiscountLimit(); //혜택 한도

        //1. 해당 카테고리의 누적혜택금액이 한도를 채웠으면 혜택 0원
        if(benefitAmount >= discountLimit){
            return 0;
        }
        //2. 넘지 않았으면 계산
        else {
            int price = transaction.getPrice(); //소비금액
            int discountLine = categoryBenefit.getDiscountLine(); //혜택기준
            int discountAmount = categoryBenefit.getDiscountAmount(); //혜택크기
            //할인형일 때
            if(card.getBenefitCode().equals(BenefitCode.DISCOUNT)){
                return transactionService.getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, categoryBenefit.getSign());
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    int result = transactionService.getDiscountAmountUsingSign(price, discountAmount, categoryBenefit.getSign());
                    //결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                    //넘거나 같으면
                    if(benefitAmount + result >= discountLimit){
                        // 남은 한도만큼만 리턴
                        return discountLimit - benefitAmount;
                    } else{ //넘지 않으면 계산된 혜택 리턴
                        return result;
                    }
                }
                //넘지 않았으면
                else {
                    return 0;
                }
            }
        }
    }

    //당월 전체 카테고리별 사용내역을 가져와서 특정 카드의 혜택으로 혜택 계산
    public int calculateBenefitWithMyCard(MyCard myCard, String CategoryCode) {
        //당월 누적된 혜택 금액
        int accumulateBenefit = 0;
        //당월 1일 가져오기
        LocalDate now = MonthDay.DECEMBER.toLocalDate();
        now.withDayOfMonth(1);
        LocalDate endDate = now.plusMonths(1);
        //실제 서비스를 하게 되면 날짜 기준 잡는 로직은 전부 수정해야 함. 현재는 12/31이라는 가정임.

        //해당 카드가 해당 카테고리에서 혜택이 있는지 확인

        //당월 전체 사용내역
        while (now.isBefore(endDate)) {
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), now);
            for(Transaction transaction : transactionList){
                //사용내역으로 혜택
            }
            now = now.plusDays(1);
        }
    }


    //내 카드 당월 사용내역 가져오기
    List<Transaction> getMonthTransactionsByMyCard(MyCard myCard){
        List<Transaction> mainTransactionList = new ArrayList<>();
        //당월 1일 가져오기
        LocalDate now = MonthDay.DECEMBER.toLocalDate();
        now.withDayOfMonth(1);
        LocalDate endDate = now.plusMonths(1);
        //실제 서비스를 하게 되면 날짜 기준 잡는 로직은 전부 수정해야 함. 현재는 12/31이라는 가정임.
        while (now.isBefore(endDate)) {
            //해당일자 사용 내역들 가져오기
            List<Transaction> subTransactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), now);
            //없으면 넘기기
            if (subTransactionList.size() == 0) {
                now = now.plusDays(1);
                continue;
            }
            //main 사용 내역에 담아주기
            for(Transaction transaction : subTransactionList){
                mainTransactionList.add(transaction);
            }
            now = now.plusDays(1);
        }
        return mainTransactionList;
    }

    //카테고리 이름으로 카테고리코드 뽑기
    //내 카드 리스트 돌리면서 해당하는 카테고리에 갖고 있는 혜택 있는지 확인
    //혜택 갖고 있으면 혜택 계산하는 메서드 호출

    //받을 수 있는 최대 혜택 계산해서
    //최대 혜택을 주는 카드와 혜택값 반환하기
    public CardWithMaxBenefit getMaxBenefitAmount(int memberId, String categoryName){
        CardWithMaxBenefit resultCardMaxBenefit;
        //비교대상이 될 CardMaxBenefit 객체 : 기본 정보는 mycardid가 1인 카드
        CardWithMaxBenefit compareTargetCardMaxBenefit = CardWithMaxBenefit.from(mycardRepository.findById(1).get(), Integer.MIN_VALUE);
        //카테고리이름으로 공통코드 가져오기
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName)
                .orElseThrow((() ->
                        new RuntimeException()));
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList){
            //해당 카테고리의 예외 혜택 있는지 확인
            //카드아이디와 카테고리코드로 확인
            Card card = myCard.getCard();
            Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitRepository.findByCardIdAndCategoryCode(card.getId(), subCommonCode.getDetailCode());
            //예외 혜택 존재하면 예외혜택으로 계산하기
            if(exceptionBenefit.isPresent()){
                int benefitAmount = 0;
                //당월 사용내역 가져와서
                List<Transaction> transactionList = getMonthTransactionsByMyCard(myCard);
                //혜택 적용해서 계산한 값을 가져오기
                for(Transaction transaction : transactionList){
                    benefitAmount += calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get());
                }
                //계산된 혜택이 최대혜택값보다 크면 resultCardMaxBenefit 갱신
                if(benefitAmount > compareTargetCardMaxBenefit.getMaxBenefit()){
                    resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                }
                //만약 혜택 값이 같으면
                else{
                    //실적 비교
                    //내 카드아이디로 당월누적사용금액 가져오기
                    int targetAccumulate = goalRepository.findByMyCardId(compareTargetCardMaxBenefit.getMyCard().getId()).getAccumulate();
                    int resultAccumulate = goalRepository.findByMyCardId(myCard.getId()).getAccumulate();

                    //둘 중 실적이 더 많이 남아있는 (값 비교했을 때 더 작은) 것 추천
                    //여기서도 같으면 타켓카드를 추천
                    if(resultAccumulate >= targetAccumulate){
                        resultCardMaxBenefit = CardWithMaxBenefit.from(compareTargetCardMaxBenefit.getMyCard(), compareTargetCardMaxBenefit.getMaxBenefit());
                    }
                    else{
                        resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                    }
                }
            }
            //없으면 카테고리 혜택 있는지 확인
            else{
                //카드아이디와 카테고리코드로 확인
                Optional<CategoryBenefit> categoryBenefit = categoryBenefitRepository.findCategoryBenefitByCardIdAndCategoryCode(card.getId(), subCommonCode.getDetailCode());
                //카테고리 혜택 존재하면 카테고리 혜택으로 계산하기
                if(categoryBenefit.isPresent()){
                    //당월 사용내역 가져와서 혜택 적용해서 계산한 값을 가져오기
                }
                //카테고리 혜택도 없으면 0 리턴
                else{
                }
            }
       }
        return resultCardMaxBenefit;
    }



    /*
    Card - 추천해줄 카드
    List<CardBenefitDetails> - 혜택 디테일 정보
    int recievedBenefitAmount - 받은 혜택
    int maxBenefitAmount - 받을 수 있던 최대 혜택
     */
    public CardRecommendationResponse getCardRecommendationResponse(int memberId, String categoryName){

        return CardRecommendationResponse.toResponse()
    }


    //혜택 상세 정보 가져오기 - 예외
    public List<CardBenefitDetails> getCardBenefitDetails(ExceptionBenefit exceptionBenefit) {
        List<CardBenefitDetails> cardBenefitDetailsList = new ArrayList<>();

        return cardBenefitDetailsList;
    }

    //혜택 상세 정보 가져오기 - 카테고리
    public List<CardBenefitDetails> getCardBenefitDetails(CategoryBenefit categoryBenefit) {
        List<CardBenefitDetails> cardBenefitDetailsList = new ArrayList<>();

        return cardBenefitDetailsList;
    }
}
