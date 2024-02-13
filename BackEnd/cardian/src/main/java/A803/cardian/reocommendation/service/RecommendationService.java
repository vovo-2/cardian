package A803.cardian.reocommendation.service;

import A803.cardian.Exception.ErrorCode;
import A803.cardian.Exception.ErrorException;
import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.benefit.domain.CardCategoryMapping;
import A803.cardian.benefit.domain.CategoryBenefit;
import A803.cardian.benefit.domain.ExceptionBenefit;
import A803.cardian.benefit.repository.CardCategoryMappingRepository;
import A803.cardian.benefit.repository.CategoryBenefitRepository;
import A803.cardian.benefit.repository.ExceptionBenefitRepository;
import A803.cardian.benefit.serivce.ExceptionBenefitService;
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
import A803.cardian.reocommendation.data.dto.response.CategoryBenefitAccumulate;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.domain.AccumulateCategoryBenefit;
import A803.cardian.statistic.domain.AccumulateExceptionBenefit;
import A803.cardian.statistic.repository.AccumulateBenefitRepository;
import A803.cardian.statistic.repository.AccumulateCategoryBenefitRepository;
import A803.cardian.statistic.repository.AccumulateExceptionBenefitRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
public class RecommendationService {
    private final TransactionRepository transactionRepository;
    private final MycardRepository mycardRepository;
    private final ExceptionBenefitRepository exceptionBenefitRepository;
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final CategoryBenefitRepository categoryBenefitRepository;
    private final AssociateRepository associateRepository;
    private final CardCategoryMappingRepository cardCategoryMappingRepository;
    private final AccumulateBenefitRepository accumulateBenefitRepository;
    private final AccumulateExceptionBenefitRepository accumulateExceptionBenefitRepository;
    private final AccumulateCategoryBenefitRepository accumulateCategoryBenefitRepository;
    private final TransactionService transactionService;
    private final ExceptionBenefitService exceptionBenefitService;

    //할인금액 계산
    //예외혜택
    public int calculateDiscountAmountWithExceptionBenefit(Transaction transaction, ExceptionBenefit exceptionBenefit, int benefitAmount) {

        Card card = transaction.getMyCard().getCard();
        int calAmount = 0; //계산될 혜택 값
        int discountLimit = exceptionBenefit.getDiscountLimit(); //혜택 한도

        //1. 해당 카테고리의 누적혜택금액이 한도를 채웠으면 혜택 0원
        if (benefitAmount >= discountLimit) {
            return 0;
        }
        //2. 넘지 않았으면 계산
        else {
            int price = transaction.getPrice(); //소비금액
            int discountLine = exceptionBenefit.getDiscountLine(); //혜택기준
            int discountAmount = exceptionBenefit.getDiscountAmount(); //혜택크기
            //할인형일 때
            if (card.getBenefitCode().equals(BenefitCode.DISCOUNT)) {
                calAmount = transactionService.getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, exceptionBenefit.getSign());//결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                //넘거나 같으면
                if (benefitAmount + calAmount >= discountLimit) {
                    // 남은 한도만큼만 리턴
                    return discountLimit - benefitAmount;
                } else { //넘지 않으면 계산된 혜택 리턴
                    return calAmount;
                }
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    int result = transactionService.getDiscountAmountUsingSign(price, discountAmount, exceptionBenefit.getSign());

                    //결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                    //넘거나 같으면
                    if (benefitAmount + result >= discountLimit) {
                        // 남은 한도만큼만 리턴
                        return discountLimit - benefitAmount;
                    } else { //넘지 않으면 계산된 혜택 리턴
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
    //카테고리혜택 -> 잘못된 부분 있는 듯
    public int calculateDiscountAmountWithCategoryBenefit(Transaction transaction, CategoryBenefit categoryBenefit, int benefitAmount) {
        Card card = transaction.getMyCard().getCard();
        System.out.println("카드 종류 " + card.getBenefitCode());
        int calAmount = 0; //계산될 혜택 값
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
                calAmount = transactionService.getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, categoryBenefit.getSign());
                System.out.println("계산된 할인값 : " + calAmount);
                //결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                //넘거나 같으면
                if(benefitAmount + calAmount >= discountLimit){
                    // 남은 한도만큼만 리턴
                    return discountLimit - benefitAmount;
                } else{ //넘지 않으면 계산된 혜택 리턴
                    return calAmount;
                }
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    calAmount = transactionService.getDiscountAmountUsingSign(price, discountAmount, categoryBenefit.getSign());
                    System.out.println("계산된 혜택값 : " + calAmount);
                    //결과혜택을 누적혜택에 더했을 때 한도를 넘는지 확인
                    //넘거나 같으면
                    if(benefitAmount + calAmount >= discountLimit){
                        // 남은 한도만큼만 리턴
                        return discountLimit - benefitAmount;
                    } else{ //넘지 않으면 계산된 혜택 리턴
                        return calAmount;
                    }
                }
                //넘지 않았으면
                else {
                    return 0;
                }
            }
        }
    }

    //특정 카드 당월 누적 금액 가져오기
    public int getMonthAccumulate(MyCard myCard, LocalDate now){
        int monthAccumulate = 0;
        LocalDate startDate = now.withDayOfMonth(1);
        while(startDate.isBefore(now)){
            //해당일자 사용 내역들 가져오기
            List<Transaction> subTransactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), startDate);
            //없으면 넘기기
            if (subTransactionList.size() == 0) {
                startDate = startDate.plusDays(1);
                continue;
            }
            //소비금액 더해주기
            for (Transaction transaction : subTransactionList) {
                monthAccumulate += transaction.getPrice();
            }
            startDate = startDate.plusDays(1);
        }

        return monthAccumulate;
    }

    //당월 모든 사용내역 가져오기
    public List<Transaction> getEntireMonthTransactions(int memberId, LocalDate now){
        //당월 1일로 바꿔주기
        LocalDate startDate = now.withDayOfMonth(1);
        //다음달 1일
        LocalDate endDate = startDate.plusMonths(1);
        List<Transaction> mainTransactionList = new ArrayList<>();
        //사용내역 뽑아올 내 카드 리스트 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList) {
            while (startDate.isBefore(endDate)) {
                //해당일자 사용 내역들 가져오기
                List<Transaction> subTransactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), startDate);
                //없으면 넘기기
                if (subTransactionList.size() == 0) {
                    startDate = startDate.plusDays(1);
                    continue;
                }
                //main 사용 내역에 담아주기
                for (Transaction transaction : subTransactionList) {
                    mainTransactionList.add(transaction);
                }
                startDate = startDate.plusDays(1);
            }
            //당월 1일로 바꿔주기
            startDate = now.withDayOfMonth(1);
            //다음달 1일
            endDate = startDate.plusMonths(1);
        }
        return mainTransactionList;
    }

    /*
        카테고리 이름으로 카테고리코드 뽑기
        내 카드 리스트 돌리면서 해당하는 카테고리에 갖고 있는 혜택 있는지 확인
        혜택 갖고 있으면 혜택 계산하는 메서드 호출
     */
    //받을 수 있는 최대 혜택 계산해서 최대 혜택을 주는 카드와 혜택값 반환하기
    public CardWithMaxBenefit getMaxBenefitAmount(int memberId, String categoryName){
        //현재
//        LocalDate now = LocalDate.now();
        LocalDate now = MonthDay.DECEMBER.toLocalDate();//현재는 12/31일이라는 가정임

        //최대 혜택의 카드, 그 카드의 계산 혜택값
        CardWithMaxBenefit resultCardMaxBenefit = CardWithMaxBenefit.from(null, Integer.MIN_VALUE);
        //카테고리이름으로 공통코드 가져오기
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName)
                .orElseThrow(() ->
                        new ErrorException(ErrorCode.NO_SUBCOMMONCODE));
        String categoryCode = subCommonCode.getDetailCode();

        //당월 전체 사용내역 가져와서
        List<Transaction> transactionList = getEntireMonthTransactions(memberId, now);

        //내 카드 리스트 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList){
            //해당 카테고리의 예외 혜택 있는지 확인
            //카드아이디와 카테고리코드로 확인
            Card card = myCard.getCard();
            Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitRepository.findByCardIdAndCategoryCode(card.getId(), categoryCode);
            //예외 혜택 존재하면 예외혜택으로 계산하기
            if(exceptionBenefit.isPresent()){
                //예외혜택이 적용되는 제휴사 아이디
                int associateId = exceptionBenefit.get().getAssociateId();

                int benefitAmount = 0;

                //혜택 적용해서 계산한 값을 가져오기 - 로직
                for(Transaction transaction : transactionList){
                    //해당 소비내역 제휴사가 예외혜택에 포함이면 계산해주기
                    Associate associate = associateRepository.findByName(transaction.getStore())
                            .orElseThrow(() ->
                                    new RuntimeException());
                    //예외혜택에 속하지 않으면 넘기기
                    if(associate.getId() != associateId){
                        continue;
                    }
                    System.out.println("현재 보는 예외 혜택 제휴처 " + associate.getName());

                    benefitAmount += calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get(), benefitAmount);
                    System.out.println("현재 누적 예외혜택금액 : " + benefitAmount);
                }
                //당월 해당 예외카테고리 혜택값 가져오기 - 테이블
//                AccumulateExceptionBenefit accumulateExceptionBenefit = accumulateExceptionBenefitRepository.findByMyCardIdAndCategoryCode(myCard.getId(), categoryCode)
//                        .orElseThrow(() ->
//                                new RuntimeException());
//                benefitAmount = accumulateExceptionBenefit.getBenefitAmount();

                System.out.println("계산된 혜택 : " + benefitAmount + " 혜택 한도를 넘으면 안됨");
                //계산된 혜택이 최대혜택값보다 크면 resultCardMaxBenefit 갱신
                //여기서 무조건 mycard 객체가 들어감
                if(benefitAmount > resultCardMaxBenefit.getMaxBenefit()){
                    resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                }
                //만약 혜택 값이 같으면
                else if(benefitAmount == resultCardMaxBenefit.getMaxBenefit()){
                    //실적 비교
                    //내 카드아이디로 당월누적사용금액 가져오기
//                    int targetAccumulate = goalRepository.findByMyCardId(resultCardMaxBenefit.getMyCard().getId()).getAccumulate();
//                    int resultAccumulate = goalRepository.findByMyCardId(myCard.getId()).getAccumulate();
                    int targetAccumulate = getMonthAccumulate(resultCardMaxBenefit.getMyCard(), now);
                    int resultAccumulate = getMonthAccumulate(myCard, now);

                    //둘 중 실적이 더 많이 남아있는 (값 비교했을 때 더 작은) 것 추천
                    //여기서도 같으면 resultCardMaxBenefit 갱신해주지 않음
                    //현재 보는 카드 실적 목표가 많이 남아있으면 값 갱신
                    if(resultAccumulate < targetAccumulate){
                        resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                    }
                }
            }
            //카테고리 혜택 있는지 확인
            //카드아이디와 카테고리코드로 확인
            Optional<CategoryBenefit> categoryBenefit = categoryBenefitRepository.findCategoryBenefitByCardIdAndCategoryCode(card.getId(), categoryCode);
            //카테고리 혜택 존재하면 카테고리 혜택으로 계산하기
            if(categoryBenefit.isPresent()){
                //카테고리혜택이 적용되는 제휴사 아이디 리스트
                List<CardCategoryMapping> cardCategoryMappingList = cardCategoryMappingRepository.findCardCategoryMappingsByCategoryBenefitId(categoryBenefit.get().getId());
                List<Integer> associateIdList = new ArrayList<>();
                for(CardCategoryMapping cardCategoryMapping : cardCategoryMappingList){
                    associateIdList.add(cardCategoryMapping.getAssociate().getId());
                }

                int benefitAmount = 0;
//                //당월 사용내역 가져와서
//                List<Transaction> transactionList = getEntireMonthTransactions(memberId, now);
                //혜택 적용해서 계산한 값을 가져오기 - 로직
                    for(Transaction transaction : transactionList){
                        //해당 소비내역 제휴사가 예외혜택에 포함이면 계산해주기
                        Associate associate = associateRepository.findByName(transaction.getStore())
                                .orElseThrow(() ->
                                        new RuntimeException());
                        //카테고리 혜택에 속하면
                        for(Integer associateId : associateIdList){
                            if(associateId == associate.getId()){
                                System.out.println("현재 보는 카테고리 혜택 제휴처 " + associate.getName());

                                benefitAmount += calculateDiscountAmountWithCategoryBenefit(transaction, categoryBenefit.get(), benefitAmount);

                                System.out.println("현재 누적 카테고리혜택금액 : " + benefitAmount);
                            }
                        }
                    }
                //당월 해당 카테고리 혜택값 가져오기 - 테이블
//                AccumulateCategoryBenefit accumulateCategoryBenefit = accumulateCategoryBenefitRepository.findByMyCardIdAndCategoryBenefitId(myCard.getId(), categoryBenefit.get().getId())
//                        .orElseThrow(()->
//                                new RuntimeException());
//                benefitAmount = accumulateCategoryBenefit.getBenefitAmount();

                System.out.println("계산된 혜택 : " + benefitAmount + " 혜택 한도를 넘으면 안됨");
                //계산된 혜택이 최대혜택값보다 크면 resultCardMaxBenefit 갱신
                if(benefitAmount > resultCardMaxBenefit.getMaxBenefit()){
                    resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                }
                //만약 혜택 값이 같으면
                else if(benefitAmount == resultCardMaxBenefit.getMaxBenefit()){
                    //실적 비교
                    //내 카드아이디로 당월누적사용금액 가져오기
//                        int targetAccumulate = goalRepository.findByMyCardId(resultCardMaxBenefit.getMyCard().getId()).getAccumulate();
//                        int resultAccumulate = goalRepository.findByMyCardId(myCard.getId()).getAccumulate();
                    int targetAccumulate = getMonthAccumulate(resultCardMaxBenefit.getMyCard(), now);
                    int resultAccumulate = getMonthAccumulate(myCard, now);


                    //둘 중 실적이 더 많이 남아있는 (값 비교했을 때 더 작은) 것 추천
                    //여기서도 같으면 resultCardMaxBenefit 갱신해주지 않음
                    //현재 보는 카드 실적 목표가 많이 남아있으면 값 갱신
                    if(resultAccumulate < targetAccumulate){
                        resultCardMaxBenefit = CardWithMaxBenefit.from(myCard, benefitAmount);
                    }
                }
            }
            //카테고리 혜택도 없으면 0 리턴
            else{
                continue;
            }
        }
        System.out.println("현재 가장 큰 혜택인 카드 : " + resultCardMaxBenefit.getMyCard().getCard().getName() + " 혜택값 : " + resultCardMaxBenefit.getMaxBenefit());

        return resultCardMaxBenefit; //카테고리가 모든 카드에 혜택이 없으면 null 반환인데 우리 데이터는 그런 경우 없음. null 반환될 일 없다.
    }

    /*
    associate - 제휴사 이름
    discontAmount - 할인크기
    sign - + / %
     */
    //해당 카드의 혜택 디테일 정보 가져오기
    List<CardBenefitDetails> getCardBenefitDetails(Card card, String categoryName){
        List<CardBenefitDetails> cardBenefitDetailsList = new ArrayList<>();
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName)
                .orElseThrow(() ->
                        new ErrorException(ErrorCode.NO_SUBCOMMONCODE));
        String categoryCode = subCommonCode.getDetailCode();
        //해당 카드의 모든 혜택 가져오기
        //1. 예외 혜택 가져오기
        Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitRepository.findByCardIdAndCategoryCode(card.getId(), categoryCode);
        //예외 혜택 존재하면
        if(exceptionBenefit.isPresent()) {
            //예외 혜택의 제휴사 가져오기
            Associate exceptionAssociate = associateRepository.findById(exceptionBenefit.get().getAssociateId())
                    .orElseThrow(() ->
                            new ErrorException(ErrorCode.NO_ASSOCIATE));
            //넣어주기
            cardBenefitDetailsList.add(CardBenefitDetails.from(exceptionBenefit.get(), exceptionAssociate));
        }

        //2. 카테고리 혜택 가져오기
        List<CategoryBenefit> categoryBenefitList = categoryBenefitRepository.findCategoryBenefitsByCardIdAndCategoryCode(card.getId(), categoryCode);
        for(CategoryBenefit categoryBenefit : categoryBenefitList){
            //제휴사 가져오기 위해 카드카테고리매핑객체 가져오기
            List<CardCategoryMapping> cardCategoryMappingList = cardCategoryMappingRepository.findCardCategoryMappingsByCategoryBenefitId(categoryBenefit.getId());
            for(CardCategoryMapping cardCategoryMapping : cardCategoryMappingList){
                Associate categoryAssociate = cardCategoryMapping.getAssociate();
                cardBenefitDetailsList.add(CardBenefitDetails.from(categoryBenefit, categoryAssociate));
            }
        }
        return cardBenefitDetailsList;
    }

    //특정 카드의 특정 카테고리의 혜택들을 혜택누적합(0으로 초기화)과 함께 List로 가져오기
    List<CategoryBenefitAccumulate> getCategoryBenefitAccumulateList(Card card, String categoryCode) {
        List<CategoryBenefitAccumulate> categoryBenefitAccumulateList = new ArrayList<>();
        //카드의 해당 카테고리 혜택 가져오기
        List<CategoryBenefit> categoryBenefitLsit = categoryBenefitRepository.findCategoryBenefitsByCardIdAndCategoryCode(card.getId(), categoryCode);
        for(CategoryBenefit categoryBenefit : categoryBenefitLsit){
            //각 혜택과 혜택 누적값(0으로 초기화) 해서 넣어주기
            categoryBenefitAccumulateList.add(CategoryBenefitAccumulate.from(categoryBenefit, 0));
        }
        return categoryBenefitAccumulateList;
    }

    //카드별 카테고리 당월 혜택 금액 계산
    public int getRecievedBenefitAmountPerMyCard(MyCard myCard, LocalDate now, String categoryName) {
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName).get();
        String categoryCode = subCommonCode.getDetailCode();

        int recievedBenefitAmountPerMyCard = 0; // 당월 혜택값
        int exceptionBenefitAmount = 0; //예외 혜택의 누적 혜택값
        //해당 카드의 해당 카테고리 관련 혜택들
        List<CategoryBenefitAccumulate> categoryBenefitAccumulateList = getCategoryBenefitAccumulateList(myCard.getCard(), categoryCode);

        LocalDate startDate = now.withDayOfMonth(1);
        while (startDate.isBefore(now)) {
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), startDate);
            for (Transaction transaction : transactionList) {
                //1. 제휴사 가져오기
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new ErrorException(ErrorCode.NO_ASSOCIATE));
                //제휴사가 해당 카테고리가 아니면 넘기기
                if(!associate.getCategoryCode().equals(categoryCode)){
                    continue;
                }
                //2. recievedBenefitAmountPerMyCard 계산하기
                //예외 혜택인지 카테고리 혜택인지 확인
                Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitService.getExceptionBenefit(transaction);
                //예외혜택이 있으면 예외 혜택으로 계산
                if (exceptionBenefit.isPresent()) {
                    exceptionBenefitAmount += calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get(), exceptionBenefitAmount);
                } else {
                    //없으면 카드카테고리매핑객체 가져와서
                    //해당 카드의 제휴사가 속한 카테고리
                    Optional<CardCategoryMapping> cardCategoryMapping = cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), myCard.getId());
                    //있으면
                    if (cardCategoryMapping.isPresent()) {
                        //카테고리혜택 가져와서 계산
                        CategoryBenefit categoryBenefit = cardCategoryMapping.get().getCategoryBenefit();
                        //해당 카테고리 혜택의 누적 혜택 값 가져와서 계산해주기
                        for(int i = 0; i < categoryBenefitAccumulateList.size(); i++){
                            //같은 카테고리 혜택 객체 가져오기
                            if(categoryBenefit.equals(categoryBenefitAccumulateList.get(i).getCategoryBenefit())){
                                //누적 혜택 값 가져오기
                                int categoryBenefitAmount = categoryBenefitAccumulateList.get(i).getBenefitAccumulate();
                                //혜택 한도
                                int discountLimit = categoryBenefit.getDiscountLimit();

                                //누적 혜택값이 한도와 같거나 크면 넘기기
                                if(categoryBenefitAmount >= discountLimit){
                                    continue;
                                }

                                //계산된 혜택
                                int calAmount = calculateDiscountAmountWithCategoryBenefit(transaction, categoryBenefit, categoryBenefitAmount);
                                //누적합 + 계산혜택
                                int newAccumulate = categoryBenefitAmount + calAmount;

                                //newAccumulate가 한도를 넘으면 한도값을 넣어주기
                                if(newAccumulate >= discountLimit){
                                    newAccumulate = discountLimit;
                                }
                                //새로 넣어줌
                                categoryBenefitAccumulateList.remove(categoryBenefitAccumulateList.get(i));
                                categoryBenefitAccumulateList.add(i, CategoryBenefitAccumulate.from(categoryBenefit, newAccumulate));
                                i++;
                            }
                        }
                    }
                }
            }
            startDate = startDate.plusDays(1);
        }
        for(CategoryBenefitAccumulate categoryBenefitAccumulate : categoryBenefitAccumulateList){
            recievedBenefitAmountPerMyCard += categoryBenefitAccumulate.getBenefitAccumulate();
        }
        recievedBenefitAmountPerMyCard += exceptionBenefitAmount;
        System.out.println("카드 이름 : " + myCard.getCard().getName() + " 의 카테고리 " + categoryName + "에서의 받은 혜택 금액 : " + recievedBenefitAmountPerMyCard);
        return recievedBenefitAmountPerMyCard;
    }

    //카테고리별 실제 받은 혜택 계산하기 - 로직
//    public int getRecievedBenefitAmount(int memberId, String categoryName){
//        int recievedBenefitAmount = 0;
//        //내 카드 리스트
//        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
//        for(MyCard myCard : myCardList){
//            LocalDate now = MonthDay.DECEMBER.toLocalDate(); //현재 시점 12/31 가정.
//            recievedBenefitAmount += getRecievedBenefitAmountPerMyCard(myCard, now, categoryName);
//        }
//        return recievedBenefitAmount;
//    }
    //카테고리별 실제 받은 혜택 계산하기 - 로직

    //카테고리별 실제 받은 혜택 계산하기 - 테이블
    public int getRecievedBenefitAmount(int memberId, String categoryName){
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName)
                .orElseThrow(() ->
                        new RuntimeException());
        String categoryCode = subCommonCode.getDetailCode();
        int recievedBenefitAmount = 0;
        //내 카드 리스트
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList){
            Optional<AccumulateBenefit> accumulateBenefit = accumulateBenefitRepository.findAccumulateBenefitByMyCardIdAndCategoryCode(myCard.getId(), categoryCode);
            if(accumulateBenefit.isPresent()) {
                recievedBenefitAmount += accumulateBenefit.get().getBenefitAmount();
            }
        }
        return recievedBenefitAmount;
    }
    //카테고리별 실제 받은 혜택 계산하기 - 테이블
    /*
    Card - 추천해줄 카드
    List<CardBenefitDetails> - 혜택 디테일 정보
    int recievedBenefitAmount - 받은 혜택
    int maxBenefitAmount - 받을 수 있던 최대 혜택
     */
    public CardRecommendationResponse getCardRecommendationResponse(int memberId, String categoryName){
        CardWithMaxBenefit cardWithMaxBenefit = getMaxBenefitAmount(memberId, categoryName);
        Card card = cardWithMaxBenefit.getMyCard().getCard();
        int maxBenefitAmount = cardWithMaxBenefit.getMaxBenefit();
        List<CardBenefitDetails> cardBenefitDetailsList = getCardBenefitDetails(card, categoryName);
        int recieveBenefitAmount = getRecievedBenefitAmount(memberId, categoryName);

        return CardRecommendationResponse.toResponse(card, cardBenefitDetailsList, recieveBenefitAmount, maxBenefitAmount);
    }
}
