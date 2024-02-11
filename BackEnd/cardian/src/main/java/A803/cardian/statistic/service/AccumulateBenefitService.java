package A803.cardian.statistic.service;

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
import A803.cardian.card.domain.Transaction;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.card.service.TransactionService;
import A803.cardian.member.domain.Member;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.reocommendation.data.dto.response.CategoryBenefitAccumulate;
import A803.cardian.statistic.data.dto.response.accumulateBenefit.CategoryBenefitPerCard;
import A803.cardian.statistic.data.dto.response.accumulateBenefit.CategoryBenefitPerCategory;
import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.SubCommonCodeRepository;
import A803.cardian.reocommendation.service.RecommendationService;
import A803.cardian.statistic.data.dto.response.accumulateBenefit.CategoryBenefitPerCategoryBenefit;
import A803.cardian.statistic.data.dto.response.accumulateBenefit.CategoryBenefitPerExceptionBenefit;
import A803.cardian.statistic.domain.AccumulateBenefit;
import A803.cardian.statistic.domain.AccumulateCategoryBenefit;
import A803.cardian.statistic.domain.AccumulateExceptionBenefit;
import A803.cardian.statistic.domain.MonthlyCardStatistic;
import A803.cardian.statistic.repository.AccumulateBenefitRepository;
import A803.cardian.statistic.repository.AccumulateCategoryBenefitRepository;
import A803.cardian.statistic.repository.AccumulateExceptionBenefitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
@Slf4j
public class AccumulateBenefitService {
    private final MemberRepository memberRepository;
    private final CategoryBenefitRepository categoryBenefitRepository;
    private final TransactionRepository transactionRepository;
    private final AssociateRepository associateRepository;
    private final AccumulateBenefitRepository accumulateBenefitRepository;
    private final MycardRepository mycardRepository;
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final CardCategoryMappingRepository cardCategoryMappingRepository;
    private final AccumulateCategoryBenefitRepository accumulateCategoryBenefitRepository;
    private final AccumulateExceptionBenefitRepository accumulateExceptionBenefitRepository;
    private final ExceptionBenefitRepository exceptionBenefitRepository;
    private final ExceptionBenefitService exceptionBenefitService;
    private final TransactionService transactionService;

    //카테고리별 누적 혜택 금액 테이블 관련 시작--------------------------------------------------------------------
    //1. 회원가입 시 (처음) 전체 소비내역으로 계산해준 후 insert 시작
    public void saveAccumulateBenefit(int memberId) {
        System.out.println("누적액 테이블 save");
        //        LocalDate now = LocalDate.now();
        LocalDate now = MonthDay.DECEMBER.toLocalDate(); //현재 시점 12/31 가정.

        //카테고리 가져오기
        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        //내 카드 전체 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        //값 가져올 객체 리스트 생성
        List<CategoryBenefitPerCard> categoryBenefitPerCardList = new ArrayList<>();

        //카드별 당월 소비 내역 가져오기
        for (MyCard myCard : myCardList) {
            //카테고리별 혜택 금액 정보 리스트
            List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList = new ArrayList<>();

            for (SubCommonCode subCommonCode : subCommonCodeList) {
                String categoryCode = subCommonCode.getDetailCode();

                categoryBenefitPerCategoryList.add(getCategoryBenefitPerCategory(myCard, now, categoryCode));
            }

            categoryBenefitPerCardList.add(CategoryBenefitPerCard.from(myCard.getId(), categoryBenefitPerCategoryList));
        }
        log.info("카드별 리스트 사이즈{}", categoryBenefitPerCardList.size());

        //객체 생성해서 테이블에 넣어주기
        for (CategoryBenefitPerCard categoryBenefitPerCard : categoryBenefitPerCardList) {
//            List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList = new ArrayList<>();
            List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList = categoryBenefitPerCard.getCategoryBenefitPerCategoryList();
            //내 카드 아이디
            int myCardId = categoryBenefitPerCard.getMyCardId();

            for (CategoryBenefitPerCategory categoryBenefitPerCategory : categoryBenefitPerCategoryList) {
                //카테고리 코드
                String categoryCode = categoryBenefitPerCategory.getCategoryCode();
                //카드별 카테고리별 누적혜택 금액
                int monthBenefit = categoryBenefitPerCategory.getMonthBenefit();

                System.out.println("카테고리별 누적 혜택 " + myCardId + "번 카드 " + categoryCode + "카테고리 누적 혜택 " + monthBenefit);
                //객체 만들어서
                AccumulateBenefit accumulateBenefit = AccumulateBenefit.builder()
                        .myCardId(myCardId)
                        .categoryCode(categoryCode)
                        .benefitAmount(monthBenefit)
                        .build();
                //insert
                accumulateBenefitRepository.save(accumulateBenefit);
            }
        }
    }

    //카드별 카테고리 당월 혜택 금액 계산 CategoryBenefitPerCategory 객체 반환
    //Accumulate -category,exception table에 insert 해주기
    public CategoryBenefitPerCategory getCategoryBenefitPerCategory(MyCard myCard, LocalDate now, String categoryCode) {
        //해당 카드의 해당 카테고리 관련 카테고리 혜택들을 누적액(0)과 함께 가져오기
        List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList = getCategoryBenefitPerCategoryBenefit(myCard, categoryCode);
        //해당 카드의 해당 카테고리 관련 예외 혜택들을 누적액(0)과 함께 가져오기
        List<CategoryBenefitPerExceptionBenefit> categoryBenefitPerExceptionBenefitList = getCategoryBenefitPerExceptionBenefit(myCard, categoryCode);

        LocalDate startDate = now.withDayOfMonth(1);
        while (startDate.isBefore(now)) {
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), startDate);
            for (Transaction transaction : transactionList) {
                //1. 제휴사 가져오기
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new ErrorException(ErrorCode.NO_ASSOCIATE));
                //제휴사가 해당 카테고리가 아니면 넘기기
                if (!associate.getCategoryCode().equals(categoryCode)) {
                    continue;
                }

                //예외 혜택인지 카테고리 혜택인지 확인
                Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitService.getExceptionBenefit(transaction);
                //예외혜택이 있으면 예외 혜택으로 계산
                if (exceptionBenefit.isPresent()) {
                    //해당 예외 혜택의 누적 혜택 값 가져와서 계산해주기
                    for (int i = 0; i < categoryBenefitPerExceptionBenefitList.size(); i++) {
                        //같은 예외 혜택 객체 가져오기
                        if (exceptionBenefit.equals(categoryBenefitPerExceptionBenefitList.get(i).getExceptionBenefit())) {
                            //누적 혜택 값 가져오기
                            int exceptionBenefitAmount = categoryBenefitPerExceptionBenefitList.get(i).getBenefitAmount();
                            //혜택 한도
                            int discountLimit = exceptionBenefit.get().getDiscountLimit();

                            //누적 혜택값이 한도와 같거나 크면 넘기기
                            if (exceptionBenefitAmount >= discountLimit) {
                                continue;
                            }
                            //계산
                            int calAmount = transactionService.calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get(), exceptionBenefitAmount);
                            int newAccumulate = exceptionBenefitAmount + calAmount;
                            //새로 넣어줌
                            categoryBenefitPerExceptionBenefitList.remove(categoryBenefitPerExceptionBenefitList.get(i));
                            categoryBenefitPerExceptionBenefitList.add(i, CategoryBenefitPerExceptionBenefit.from(exceptionBenefit.get(), newAccumulate));
                            i++;
                        }
                    }
                } else {
                    //없으면 카드카테고리매핑객체 가져와서
                    //해당 카드의 제휴사가 속한 카테고리
                    Optional<CardCategoryMapping> cardCategoryMapping = cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), myCard.getId());
                    //있으면
                    if (cardCategoryMapping.isPresent()) {
                        //카테고리혜택 가져와서 계산
                        CategoryBenefit categoryBenefit = cardCategoryMapping.get().getCategoryBenefit();
                        //해당 카테고리 혜택의 누적 혜택 값 가져와서 계산해주기
                        for (int i = 0; i < categoryBenefitPerCategoryBenefitList.size(); i++) {
                            //같은 카테고리 혜택 객체 가져오기
                            if (categoryBenefit.equals(categoryBenefitPerCategoryBenefitList.get(i).getCategoryBenefit())) {
                                //누적 혜택 값 가져오기
                                int categoryBenefitAmount = categoryBenefitPerCategoryBenefitList.get(i).getBenefitAmount();
                                //혜택 한도
                                int discountLimit = categoryBenefit.getDiscountLimit();

                                //누적 혜택값이 한도와 같거나 크면 넘기기
                                if (categoryBenefitAmount >= discountLimit) {
                                    continue;
                                }

                                //계산된 혜택
                                int calAmount = transactionService.calculateDiscountAmountWithCategoryBenefit(transaction, categoryBenefit, categoryBenefitAmount);
                                //누적합 + 계산혜택
                                int newAccumulate = categoryBenefitAmount + calAmount;

                                //newAccumulate가 한도를 넘으면 한도값을 넣어주기
                                if (newAccumulate >= discountLimit) {
                                    newAccumulate = discountLimit;
                                }
                                //새로 넣어줌
                                categoryBenefitPerCategoryBenefitList.remove(categoryBenefitPerCategoryBenefitList.get(i));
                                categoryBenefitPerCategoryBenefitList.add(i, CategoryBenefitPerCategoryBenefit.from(categoryBenefit, newAccumulate));
                                i++;
                            }
                        }
                    }
                }
            }
            startDate = startDate.plusDays(1);
        }

        //카테고리혜택 금액 구하기
        int categoryBenefitAmount = 0;
        for (CategoryBenefitPerCategoryBenefit categoryBenefitPerCategoryBenefit : categoryBenefitPerCategoryBenefitList) {
            //객체 만들어서
            AccumulateCategoryBenefit accumulateCategoryBenefit = AccumulateCategoryBenefit.builder()
                    .myCardId(myCard.getId())
                    .categoryCode(categoryCode)
                    .categoryBenefitId(categoryBenefitPerCategoryBenefit.getCategoryBenefit().getId())
                    .benefitAmount(categoryBenefitPerCategoryBenefit.getBenefitAmount())
                    .build();
            //insert 해주기
            accumulateCategoryBenefitRepository.save(accumulateCategoryBenefit);

            categoryBenefitAmount += categoryBenefitPerCategoryBenefit.getBenefitAmount();
        }

        //예외혜택 금액 구하기
        int exceptionBenefitAmount = 0;
        for (CategoryBenefitPerExceptionBenefit categoryBenefitPerExceptionBenefit : categoryBenefitPerExceptionBenefitList) {
            AccumulateExceptionBenefit accumulateExceptionBenefit = AccumulateExceptionBenefit.builder()
                    .myCardId(myCard.getId())
                    .categoryCode(categoryCode)
                    .exceptionBenefitId(categoryBenefitPerExceptionBenefit.getExceptionBenefit().getId())
                    .benefitAmount(categoryBenefitPerExceptionBenefit.getBenefitAmount())
                    .build();
            //insert 해주기
            accumulateExceptionBenefitRepository.save(accumulateExceptionBenefit);

            exceptionBenefitAmount += categoryBenefitPerExceptionBenefit.getBenefitAmount();
        }

        return CategoryBenefitPerCategory.from(categoryCode, exceptionBenefitAmount + categoryBenefitAmount, categoryBenefitPerExceptionBenefitList, categoryBenefitPerCategoryBenefitList);
    }

    //특정 카드의 특정 카테고리의 카테고리혜택을 누적합 0으로 초기화해준 객체 리스트 가져오기
    public List<CategoryBenefitPerCategoryBenefit> getCategoryBenefitPerCategoryBenefit(MyCard myCard, String categoryCode) {
        List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList = new ArrayList<>();
        //카드의 해당 카테고리 혜택 가져오기
        List<CategoryBenefit> categoryBenefitList = categoryBenefitRepository.findCategoryBenefitsByCardIdAndCategoryCode(myCard.getCard().getId(), categoryCode);
        for (CategoryBenefit categoryBenefit : categoryBenefitList) {
            //각 혜택과 혜택 누적값을 넣어주기
            categoryBenefitPerCategoryBenefitList.add(CategoryBenefitPerCategoryBenefit.from(categoryBenefit, 0));
        }
        return categoryBenefitPerCategoryBenefitList;
    }

    //특정 카드의 특정 카테고리의 예외혜택을 누적합 0으로 초기화해준 객체 리스트 가져오기
    public List<CategoryBenefitPerExceptionBenefit> getCategoryBenefitPerExceptionBenefit(MyCard myCard, String categoryCode) {
        List<CategoryBenefitPerExceptionBenefit> categoryBenefitPerExceptionBenefitList = new ArrayList<>();
        //카드의 해당 카테고리 혜택 가져오기
        List<ExceptionBenefit> exceptionBenefitList = exceptionBenefitRepository.findExceptionBenefitsByCardIdAndCategoryCode(myCard.getCard().getId(), categoryCode);
        for (ExceptionBenefit exceptionBenefit : exceptionBenefitList) {
            //각 혜택과 혜택 누적값을 넣어주기
            categoryBenefitPerExceptionBenefitList.add(CategoryBenefitPerExceptionBenefit.from(exceptionBenefit, 0));
        }
        return categoryBenefitPerExceptionBenefitList;
    }

    //1. 회원가입 시 (처음) 전체 소비내역으로 계산해준 후 insert 끝

    //2. 로그인 시, updateDate를 기준으로 새 소비내역이 있으면 계산해준 후 update 시작
    public void updateAccumulateBenefit(int memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new RuntimeException());
        LocalDateTime updateDate = member.getUpdateDate();

        //카테고리 가져오기
        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        //내 카드 전체 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        //카드별 당월 소비 내역 가져오기
        for (MyCard myCard : myCardList) {
            //카테고리별 혜택 금액 정보 리스트
            List<CategoryBenefitPerCategory> categoryBenefitPerCategoryList = new ArrayList<>();

            for (SubCommonCode subCommonCode : subCommonCodeList) {
                String categoryCode = subCommonCode.getDetailCode();

                //update 하기
                updateAccumulateBenefitTable(myCard, updateDate, categoryCode);
            }
        }
    }

    public void updateAccumulateBenefitTable(MyCard myCard, LocalDateTime updateDate, String categoryCode) {
        //        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now = LocalDateTime.of(2023, 12, 31, 23, 59, 59);
        int nowMonth = now.getMonthValue();

        //해당 카드의 해당 카테고리 관련 에외혜택을 테이블에서 가져오기
        AccumulateExceptionBenefit accumulateExceptionBenefit = accumulateExceptionBenefitRepository.findByMyCardIdAndCategoryCode(myCard.getId(), categoryCode)
                .orElseThrow(() ->
                        new RuntimeException());
        int exceptionBenefitAmount = accumulateExceptionBenefit.getBenefitAmount(); //예외 혜택의 누적 혜택값

        //해당 카드의 해당 카테고리 관련 카테고리혜택들을 테이블에서 가져오기
        List<CategoryBenefitPerCategoryBenefit> categoryBenefitPerCategoryBenefitList = getCategoryBenefitPerCategoryBenefitForUpdate(myCard, categoryCode);

        //마지막 갱신일에서 현재까지
        List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardAndDateAfter(myCard, updateDate);
        for (Transaction transaction : transactionList) {
            //이번달 것만 보기
            if (transaction.getDay().getMonthValue() != nowMonth) {
                continue;
            }
            //1. 제휴사 가져오기
            Associate associate = associateRepository.findByName(transaction.getStore())
                    .orElseThrow(() ->
                            new ErrorException(ErrorCode.NO_ASSOCIATE));
            //제휴사가 해당 카테고리가 아니면 넘기기
            if (!associate.getCategoryCode().equals(categoryCode)) {
                continue;
            }
            //2. recievedBenefitAmountPerMyCard 계산하기
            //예외 혜택인지 카테고리 혜택인지 확인
            Optional<ExceptionBenefit> exceptionBenefit = exceptionBenefitService.getExceptionBenefit(transaction);
            //예외혜택이 있으면 예외 혜택으로 계산
            if (exceptionBenefit.isPresent()) {
                exceptionBenefitAmount += transactionService.calculateDiscountAmountWithExceptionBenefit(transaction, exceptionBenefit.get(), exceptionBenefitAmount);
            } else {
                //없으면 카드카테고리매핑객체 가져와서
                //해당 카드의 제휴사가 속한 카테고리
                Optional<CardCategoryMapping> cardCategoryMapping = cardCategoryMappingRepository.findByAssociateIdAndCardId(associate.getId(), myCard.getId());
                //있으면
                if (cardCategoryMapping.isPresent()) {
                    //카테고리혜택 가져와서 계산
                    CategoryBenefit categoryBenefit = cardCategoryMapping.get().getCategoryBenefit();
                    //해당 카테고리 혜택의 누적 혜택 값 가져와서 계산해주기
                    for (int i = 0; i < categoryBenefitPerCategoryBenefitList.size(); i++) {
                        //같은 카테고리 혜택 객체 가져오기
                        if (categoryBenefit.equals(categoryBenefitPerCategoryBenefitList.get(i).getCategoryBenefit())) {
                            //누적 혜택 값 가져오기
                            int categoryBenefitAmount = categoryBenefitPerCategoryBenefitList.get(i).getBenefitAmount();
                            //혜택 한도
                            int discountLimit = categoryBenefit.getDiscountLimit();

                            //누적 혜택값이 한도와 같거나 크면 넘기기
                            if (categoryBenefitAmount >= discountLimit) {
                                continue;
                            }

                            //계산된 혜택
                            int calAmount = transactionService.calculateDiscountAmountWithCategoryBenefit(transaction, categoryBenefit, categoryBenefitAmount);
                            //누적합 + 계산혜택
                            int newAccumulate = categoryBenefitAmount + calAmount;

                            //newAccumulate가 한도를 넘으면 한도값을 넣어주기
                            if (newAccumulate >= discountLimit) {
                                newAccumulate = discountLimit;
                            }
                            //새로 넣어줌
                            categoryBenefitPerCategoryBenefitList.remove(categoryBenefitPerCategoryBenefitList.get(i));
                            categoryBenefitPerCategoryBenefitList.add(i, CategoryBenefitPerCategoryBenefit.from(categoryBenefit, newAccumulate));
                            i++;
                        }
                    }
                }
            }
        }

        //카테고리혜택 금액 구하기 & update
        int categoryBenefitAmount = 0;
        for (CategoryBenefitPerCategoryBenefit categoryBenefitPerCategoryBenefit : categoryBenefitPerCategoryBenefitList) {
            //카테고리 혜택 가져오기
            CategoryBenefit categoryBenefit = categoryBenefitPerCategoryBenefit.getCategoryBenefit();
            //누적액 가져오기
            int benefitAmount = categoryBenefitPerCategoryBenefit.getBenefitAmount();
            //테이블에 저장된 객체 가져오기
            AccumulateCategoryBenefit accumulateCategoryBenefit = accumulateCategoryBenefitRepository.findByMyCardIdAndCategoryBenefitId(myCard.getId(), categoryBenefit.getId()).get();
            //누적액 update 해주기
            accumulateCategoryBenefit.updateBenefitAmount(benefitAmount);
            //더해주기
            categoryBenefitAmount += benefitAmount;
        }

        //예외혜택 update
        accumulateExceptionBenefit.updateBenefitAmount(exceptionBenefitAmount);

        //카테고리별 누적액 update
        AccumulateBenefit accumulateBenefit = accumulateBenefitRepository.findAccumulateBenefitByMyCardIdAndCategoryCode(myCard.getId(), categoryCode).get();
        accumulateBenefit.updateBenefitAmount(exceptionBenefitAmount + categoryBenefitAmount); //
    }

    //테이블에서 특정 카드의 특정 카테고리의 카테고리혜택과 누적액 객체 리스트 가져오기
    public List<CategoryBenefitPerCategoryBenefit> getCategoryBenefitPerCategoryBenefitForUpdate(MyCard myCard, String categoryCode) {
        //해당 카드의 특정 카테고리의 혜택 + 혜택 당 누적액 객체에 담아서 가져오기
        List<AccumulateCategoryBenefit> accumulateCategoryBenefitList = accumulateCategoryBenefitRepository.findAccumulateCategoryBenefitsByMyCardIdAndCategoryCode(myCard.getId(), categoryCode);
        List<CategoryBenefitPerCategoryBenefit> categoryBenefitAccumulateList = new ArrayList<>();
        for (AccumulateCategoryBenefit accumulateCategoryBenefit : accumulateCategoryBenefitList) {
            //카테고리 혜택 객체 가져오기
            CategoryBenefit categoryBenefit = categoryBenefitRepository.findById(accumulateCategoryBenefit.getCategoryBenefitId()).get();
            //누적액 가져오기
            int benefitAmount = accumulateCategoryBenefit.getBenefitAmount();
            //리스트에 담아주기
            categoryBenefitAccumulateList.add(CategoryBenefitPerCategoryBenefit.from(categoryBenefit, benefitAmount));
        }

        return categoryBenefitAccumulateList;
    }

    //2. 로그인 시, updateDate를 기준으로 새 소비내역이 있으면 계산해준 후 update 끝

    //3. 월마다 전체 초기화 시작
    public void clearAccumulateBenefitTable() {
        List<AccumulateBenefit> accumulateBenefitList = accumulateBenefitRepository.findAll();
        List<AccumulateCategoryBenefit> accumulateCategoryBenefitList = accumulateCategoryBenefitRepository.findAll();
        List<AccumulateExceptionBenefit> accumulateExceptionBenefitList = accumulateExceptionBenefitRepository.findAll();

        for (AccumulateBenefit accumulateBenefit : accumulateBenefitList) {
            accumulateBenefit.updateBenefitAmount(0);
        }
        for (AccumulateCategoryBenefit accumulateCategoryBenefit : accumulateCategoryBenefitList) {
            accumulateCategoryBenefit.updateBenefitAmount(0);
        }
        for (AccumulateExceptionBenefit accumulateExceptionBenefit : accumulateExceptionBenefitList) {
            accumulateExceptionBenefit.updateBenefitAmount(0);
        }
    }
    //3. 월마다 전체 초기화 끝

    //카테고리별 누적 혜택 금액 테이블 관련 끝--------------------------------------------------------------------
}

