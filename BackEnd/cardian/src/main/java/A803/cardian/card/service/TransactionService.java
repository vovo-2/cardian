package A803.cardian.card.service;

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
import A803.cardian.card.data.dto.response.*;
import A803.cardian.card.domain.*;

import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MyCardBenefitRepository;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.SubCommonCodeRepository;
import A803.cardian.member.domain.Member;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.reocommendation.service.RecommendationService;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.repository.AccumulateBenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class TransactionService {
    private final AssociateRepository associateRepository;
    private final TransactionRepository transactionRepository;
    private final CardCategoryMappingRepository cardCategoryMappingRepository;
    private final AccumulateBenefitRepository accumulateBenefitRepository;
    private final MycardRepository mycardRepository;
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final ExceptionBenefitService exceptionBenefitService;
//    private final RecommendationService recommendationService;

    //(예외혜택이 아니면) 카드아이디와 제휴사아이디로 카드카테고리매핑 객체를 가져와서
    //이때 없으면 이 카드로 혜택을 받을 수 없는 제휴사임.
    //카드케테고리매핑 객체에서 카테고리혜택 객체를 가져옴
    public Optional<CardCategoryMapping> getCardCategoryMappingFrom(Card card, Associate associate) {
        return cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), card.getId());
    }

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
                /*
                할인일 때의 혜택 계산 로직 구현하기
                 */
                return getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, exceptionBenefit.getSign());
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    int result = getDiscountAmountUsingSign(price, discountAmount, exceptionBenefit.getSign());
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
        if (benefitAmount >= discountLimit) {
            return 0;
        }
        //2. 넘지 않았으면 계산
        else {
            int price = transaction.getPrice(); //소비금액
            int discountLine = categoryBenefit.getDiscountLine(); //혜택기준
            int discountAmount = categoryBenefit.getDiscountAmount(); //혜택크기
            //할인형일 때
            if (card.getBenefitCode().equals(BenefitCode.DISCOUNT)) {
                /*
                할인일 때의 혜택 계산 로직 구현하기
                 */
                return getDiscountAmountUsingSignWithDiscount(price, discountLine, discountAmount, categoryBenefit.getSign());
            }
            //적립, 캐시백일 때
            else {
                //할인 기준 넘으면 계산
                if (price >= discountLine) {
                    int result = getDiscountAmountUsingSign(price, discountAmount, categoryBenefit.getSign());
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

    //할인혜택 계산하기 (적립, 캐시백)
    public int getDiscountAmountUsingSign(int price, int discountAmount, String sign) {
        if (sign.equals("+")) {
            return discountAmount;
        } else { // %일 때
            return price * discountAmount / 100;
        }
    }

    //할인혜택 계산하기 (할인)
    public int getDiscountAmountUsingSignWithDiscount(int price, int discountLine, int discountAmount, String sign) {
        //결제금액이 이미 할인기준을 충족했다면..
        //절대금액 할인일 때
        if (sign.equals("+")) {
            //예상원가
            int originPrice = price + discountAmount;
            //예상 원가가 할인 기준을 충족하면
            if (originPrice >= discountLine) {
                return discountAmount;
            }
            //충족 못 하면
            else {
                return 0;
            }
        }
        //비율금액 할인일 때
        else {
            //예상원가
            double originPrice = ((double) price / (100 - discountAmount)) * 100;
            //예상원가 올림처리
            double ceilOriginPrice = Math.ceil(originPrice);
            //올림처리한 예상원가가 할인기준보다 높으면
            if (ceilOriginPrice > (double) discountLine) {
                //할인액 계산 (예상원가 - 결제금액)
                double discount = originPrice - price;
                //할인액 내림처리
                discount = Math.floor(discount);

                return (int) discount;
            }
            //할인기준 충족 못 하면
            else {
                return 0;
            }
        }
    }

    //카드별 일별 사용 금액 계산하기
    public int getDailyAccumulate(int myCardId, LocalDate localDate) {
        int dailyAccumulate = 0;
        //카드, 일자로 사용내역 뽑아오기
        List<Transaction> transactions = transactionRepository.findTransactionsByMyCardIdAndDay(myCardId, localDate);

        //가져온 내역들의 사용 금액 누적합 구하기
        for (Transaction transaction : transactions) {
            dailyAccumulate += transaction.getPrice();
        }

        return dailyAccumulate;
    }

    //카드별 월별 사용 금액 계산하기
    public int getMonthlyAccumulate(int myCardId, LocalDate localDate) {
        int monthlyAccumulate = 0;

        //당월 1일로 바꿔주기
        if (localDate.getDayOfMonth() != 1) {
            localDate = localDate.withDayOfMonth(1);
        }

        LocalDate endMonth = localDate.plusMonths(1); //다음달 시작일
        while (localDate.isBefore(endMonth)) {
            //해당일의 사용금액 누적합을 다 더해줌
            monthlyAccumulate += getDailyAccumulate(myCardId, localDate);
            localDate = localDate.plusDays(1); //하루 늘려줌
        }

        return monthlyAccumulate;
    }

    //카드별 사용내역 일별로 가져오기
    public List<DailyTransactionDetails> getMyCardDayTransactions(int myCardId, LocalDate localDate) {
        List<Transaction> transactions = transactionRepository.findTransactionsByMyCardIdAndDay(myCardId, localDate);

        List<DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();

        for (Transaction transaction : transactions) {
            //associate, discountAmount(계산을 해주려면 혜택 정보 있어야 함)
            //1. 제휴사 가져오기
            Associate associate = associateRepository.findByName(transaction.getStore())
                    .orElseThrow(() ->
                            new ErrorException(ErrorCode.NO_ASSOCIATE));
            //2. discountAmount 계산하기
            int discountAmount;
            //예외 혜택인지 카테고리 혜택인지 확인
            Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitService.getExceptionBenefit(transaction);
            //예외혜택이 있으면 예외 혜택으로 계산
            if (exceptionBenefit.isPresent()) {
                discountAmount = calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get());
            } else {
                //없으면 카드카테고리매핑객체 가져와서
                Optional<CardCategoryMapping> cardCategoryMapping = cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), myCardId);
                //있으면
                if (cardCategoryMapping.isPresent()) {
                    //카테고리혜택 가져와서 계산
                    CategoryBenefit categoryBenefit = cardCategoryMapping.get().getCategoryBenefit();
                    discountAmount = calculateDiscountAmountWithCategoryBenefit(transaction, categoryBenefit);
                } else {
                    //없으면 혜택 없음
                    discountAmount = 0;
                }
            }
            dailyTransactionDetailsList.add(DailyTransactionDetails.from(transaction, associate, discountAmount));
        }
        return dailyTransactionDetailsList;
    }

    //카드별 사용내역 월별로 가져오기
    public List<MonthlyTransactionDetails> getMyCardMonthTransactions(int myCardId, LocalDate localDate) {
        List<MonthlyTransactionDetails> monthlyTransactionDetailsList = new ArrayList<>();

        /*
        TransactionDetails from(String day, List<DayTransactionDetails> dayTransactionDetails)
         */
//        LocalDate localDate = monthDay.toLocalDate(); //원하는 달 시작일
        LocalDate endMonth = localDate.minusDays(localDate.getDayOfMonth()); //이전달 끝

        while (localDate.isAfter(endMonth)) {
            List<DailyTransactionDetails> dailyTransactionDetailsList = getMyCardDayTransactions(myCardId, localDate);

            if (dailyTransactionDetailsList.size() == 0) {//내역 없으면 넣어주지 말기
                localDate = localDate.minusDays(1); //하루 줄여줌
                System.out.println("localDate : " + localDate);
                continue;
            }

            monthlyTransactionDetailsList.add(MonthlyTransactionDetails.from(localDate.getDayOfMonth(), dailyTransactionDetailsList));
            localDate = localDate.minusDays(1); //하루 줄여줌
            System.out.println("localDate : " + localDate);

        }

        return monthlyTransactionDetailsList;
    }

    //컨트롤러에서 부를 거
    //카드별 전체 사용내역 가져오기
    public EntireTransactionsByMyCardResponse getMyCardYearTransactioins(int myCardId) {
        List<YearTransactionDetails> yearTransactionDetailsList = new ArrayList<>();
        LocalDate start = MonthDay.DECEMBER.toLocalDate();//12월 31일

        LocalDate end = start.minusYears(1);
        while (start.isAfter(end)) {
            yearTransactionDetailsList.add(YearTransactionDetails.toResponse(myCardId, start.getMonthValue(), getMyCardMonthTransactions(myCardId, start)));
            start = start.minusMonths(1);
        }

        return EntireTransactionsByMyCardResponse.toResponse(myCardId, yearTransactionDetailsList);
    }

    //카테고리별 누적 혜택 금액 테이블 관련 시작--------------------------------------------------------------------
    //1. 회원가입 시 (처음) 전체 소비내역으로 계산해준 후 insert 시작
//    public void saveAccumulateBenefit(int memberId){
//        //        LocalDate now = LocalDate.now();
//        LocalDate now = MonthDay.DECEMBER.toLocalDate(); //현재 시점 12/31 가정.
//
//        //카테고리 가져오기
//        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
//        //내 카드 전체 가져오기
//        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
//        //값 가져올 객체 리스트 생성
//        List<CategoryBenefitPerCard> categoryBenefitPerCardList = new ArrayList<>();
//        //카드별 당월 소비 내역 가져오기
//        for(MyCard myCard : myCardList){
//            //카테고리별 혜택 금액 정보 리스트
//            List<CategoryBenefitPerCardDetatils> categoryBenefitPerCardDetatilsList = new ArrayList<>();
//
//            for(SubCommonCode subCommonCode : subCommonCodeList) {
//                String categoryCode = subCommonCode.getDetailCode();
//                //당월 누적 혜택 금액
//                int monthBenefit = getRecievedBenefitAmount(myCard, now, categoryCode);
//                categoryBenefitPerCardDetatilsList.add(CategoryBenefitPerCardDetatils.from(categoryCode, monthBenefit));
//            }
//
//            categoryBenefitPerCardList.add(CategoryBenefitPerCard.from(myCard.getId(), categoryBenefitPerCardDetatilsList));
//        }
//
//        //객체 생성해서 테이블에 넣어주기
//        for(CategoryBenefitPerCard categoryBenefitPerCard : categoryBenefitPerCardList){
//            List<CategoryBenefitPerCardDetatils> categoryBenefitPerCardDetatilsList = new ArrayList<>();
//            int myCardId = categoryBenefitPerCard.getMyCardId();
//
//            for(CategoryBenefitPerCardDetatils categoryBenefitPerCardDetatils : categoryBenefitPerCardDetatilsList){
//                String categoryCode = categoryBenefitPerCardDetatils.getCategoryCode();
//                int monthBenefit = categoryBenefitPerCardDetatils.getMonthBenefit();
//
//                AccumulateBenefit accumulateBenefit = AccumulateBenefit.builder()
//                        .myCardId(myCardId)
//                        .categoryCode(categoryCode)
//                        .benefitAmount(monthBenefit)
//                        .build();
//
//                accumulateBenefitRepository.save(accumulateBenefit);
//            }
//        }
//    }
//
//    //카테고리별 실제 받은 혜택 계산하기
//    public int getRecievedBenefitAmount(MyCard myCard, LocalDate now, String categoryName){
//        int recievedBenefitAmount = recommendationService.getRecievedBenefitAmountPerMyCard(myCard, now, categoryName);
//        return recievedBenefitAmount;
//    }
    /*
            //마지막 최종 갱신일
        LocalDateTime updateDate = member.getUpdateDate();
//        LocalDateTime now = LocalDateTime.now();
        //현재는 2023 12/31 23:59:59 라는 가정
        LocalDateTime now = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
     */

    //1. 회원가입 시 (처음) 전체 소비내역으로 계산해준 후 insert 끝

    //2. 로그인 시, updateDate를 기준으로 새 소비내역이 있으면 계산해준 후 update 시작
    public void updateAccumulateBenefit(int memberId){

    }
    //2. 로그인 시, updateDate를 기준으로 새 소비내역이 있으면 계산해준 후 update 끝

    //3. 월마다 전체 초기화 시작
    //3. 월마다 전체 초기화 끝

    //카테고리별 누적 혜택 금액 테이블 관련 끝--------------------------------------------------------------------
}
