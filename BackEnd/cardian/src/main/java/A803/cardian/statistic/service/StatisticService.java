package A803.cardian.statistic.service;

import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Transaction;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.card.service.TransactionService;
import A803.cardian.category.domain.SubCommonCode;
import A803.cardian.category.repository.SubCommonCodeRepository;
import A803.cardian.statistic.data.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StatisticService {
    private final MycardRepository mycardRepository;
    private final TransactionRepository transactionRepository;
    private final AssociateRepository associateRepository;
    private final SubCommonCodeRepository subCommonCodeRepository;
    private final TransactionService transactionService;

    //전체 카드 월별 소비금액
    public int getMonthlyConsume(int memberId, LocalDate localDate) {
        int monthlyConsume = 0;
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        //당월 1일로 바꿔주기
        if (localDate.getDayOfMonth() != 1) {
            localDate = localDate.withDayOfMonth(1);
        }
        for (MyCard myCard : myCardList) {
            int myCardId = myCard.getId();
            monthlyConsume += transactionService.getMonthlyAccumulate(myCardId, localDate);
        }
        System.out.println("월별 소비 금액 : " + localDate + " " + monthlyConsume);
        return monthlyConsume;
    }

    //전체 카드 연간 소비금액 (월별 소비금액 합)
    public int getYearConsume(int memberId) {
        int yearConsume = 0;
        LocalDate localDate = MonthDay.JANUARY.toLocalDate();
        LocalDate endDate = localDate.plusYears(1);
        while (localDate.isBefore(endDate)) {
            yearConsume += getMonthlyConsume(memberId, localDate); //월별 소비금액 더해주기
            System.out.println(" 현재 더해진 월 :  " + localDate);
            endDate = endDate.plusMonths(1);
        }
        System.out.println("총합 : " + yearConsume);
        return yearConsume;
    }

    //올해 총 소비 금액 + 월별 소비금액
    public YearConsumeWithMonthlyConsumeResponse getYearConsumeAmountWithMontlhlyConsume(int memberId) {
        int january = getMonthlyConsume(memberId, MonthDay.JANUARY.toLocalDate());
        int february = getMonthlyConsume(memberId, MonthDay.FEBRUARY.toLocalDate());
        int march = getMonthlyConsume(memberId, MonthDay.MARCH.toLocalDate());
        int april = getMonthlyConsume(memberId, MonthDay.APRIL.toLocalDate());
        int may = getMonthlyConsume(memberId, MonthDay.MAY.toLocalDate());
        int june = getMonthlyConsume(memberId, MonthDay.JUNE.toLocalDate());
        int july = getMonthlyConsume(memberId, MonthDay.JULY.toLocalDate());
        int august = getMonthlyConsume(memberId, MonthDay.AUGUST.toLocalDate());
        int september = getMonthlyConsume(memberId, MonthDay.SEPTEMBER.toLocalDate());
        int october = getMonthlyConsume(memberId, MonthDay.OCTOBER.toLocalDate());
        int november = getMonthlyConsume(memberId, MonthDay.NOVEMBER.toLocalDate());
        int december = getMonthlyConsume(memberId, MonthDay.DECEMBER.toLocalDate());
        //올해 총 소비 금액
        int yearConsume = january + february + march + april + may + june + july + august + september + october + november + december;

        YearConsumeAmount yearConsumeAmount = YearConsumeAmount.from(yearConsume, MonthlyConsumeAmount.from(january, february, march, april, may, june, july, august, september, october, november, december));

        return YearConsumeWithMonthlyConsumeResponse.toResponse(memberId, yearConsumeAmount);
    }

    //내 카드 전체 사용내역을 일자별로 가져오기
    public List<DailyTransactionDetails> getDailyTransactionDetails(int memberId, LocalDate localDate) {
        List<DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();
        //내 카드 리스트 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);

        for (MyCard myCard : myCardList) {
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);

            for (Transaction transaction : transactionList) {
                //associate 필요
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new RuntimeException());
                dailyTransactionDetailsList.add(DailyTransactionDetails.from(transaction, associate));
            }
        }

        return dailyTransactionDetailsList;
    }

    //내 카드 전체 월별 소비 내역 조회 - 해당월만 조회
    public List<DailyTransactionDetailsWithDay> getDailyTransactionDetailsWithDay(int memberId, LocalDate localDate) {
        List<DailyTransactionDetailsWithDay> dailyTransactionDetailsWithDayList = new ArrayList<>();

        LocalDate startDate = localDate;
        LocalDate endDate = localDate.plusMonths(1);
        while (startDate.isBefore(endDate)) {
            List<DailyTransactionDetails> dailyTransactionDetailsList = getDailyTransactionDetails(memberId, startDate);
            if (dailyTransactionDetailsList.size() == 0) { //내역 없으면 continue
                startDate = startDate.plusDays(1);
                continue;
            }
            //해당일의 사용내역 리스트
            dailyTransactionDetailsWithDayList.add(DailyTransactionDetailsWithDay.from(startDate.getDayOfMonth(), dailyTransactionDetailsList));
            startDate = startDate.plusDays(1);
            System.out.println("일별 사용 내역 : " + startDate);
        }
        return dailyTransactionDetailsWithDayList;
    }

    //전체 월별 소비 내역 조회 - 전체 가져오기
    public EntireCardTransactionsResponse getEntireCardTransactionsResponse(int memberId) {
        List<MonthlyTransactionDetailsWithMonth> monthlyTransactionDetailsWithMonthList = new ArrayList<>();

        LocalDate startDate = MonthDay.JANUARY.toLocalDate(); //1월부터 (01-31)
        startDate = startDate.withDayOfMonth(1); //1일로 바꿔주기
        LocalDate endDate = startDate.plusYears(1);
        while (startDate.isBefore(endDate)) {
            //해당 월 사용내역 넣어주기
            monthlyTransactionDetailsWithMonthList.add(MonthlyTransactionDetailsWithMonth.from(startDate.getMonthValue(), getDailyTransactionDetailsWithDay(memberId, startDate)));
            startDate = startDate.plusMonths(1); //다음달로 바꾸어주기
            System.out.println(startDate + " 의 사용 내역");
        }
        return EntireCardTransactionsResponse.toResponse(memberId, monthlyTransactionDetailsWithMonthList);
    }

    //카테고리별 월 총 소비 금액 계산
    public int getCategoryMonthlyConsume(int memberId, LocalDate localDate, String categoryCode) {
        int categoryMonthlyConsume = 0;
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);

        for (MyCard myCard : myCardList) {
            //특정 월의 사용 내역 다 끌어오기
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);
            for (Transaction transaction : transactionList) {
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new RuntimeException());
                //같은 카테고리 내역의 소비 금액만 더해줌
                if (categoryCode.equals(associate.getCategoryCode())) {
                    categoryMonthlyConsume += transaction.getPrice();
                }
                System.out.println(categoryCode + " === " + associate.getCategoryCode());
            }
        }
        return categoryMonthlyConsume;
    }

    //전체 월 소비 금액에서 카테고리 소비금액이 차지하는 비율 계산
    public BigDecimal getPercentageCategoryConsumeInEntireMonthlyConsume(int entireMonthlyConsume, int categoryConsume) {
        double calResult = ((double) categoryConsume / entireMonthlyConsume) * 100;
        BigDecimal percentage = new BigDecimal(Double.toString(calResult));
        // 반올림 수행 (두 번째 매개변수는 반올림 자릿수, RoundingMode.HALF_UP은 반올림 방법)
        return percentage.setScale(2, RoundingMode.HALF_UP);
    }

    //카테고리별 소비 소비 정보 (월 총 소비 금액 + 전체에서의 비율)
    public CategoryMonthlyConsumeDetails getCategoryMonthlyConsumeDetails(int memberId, LocalDate localDate, int monthlyConsume, String categoryCode) {
        //당월 카테고리 전체 소비 금액
        int categoryMonthlyConsume = 0;

        //당월의 전체 소비내역 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);

        for (MyCard myCard : myCardList) {
            //한달치 가져오기
            LocalDate startDate = localDate;
            LocalDate endDate = startDate.plusMonths(1);
            while(startDate.isBefore(endDate)){
                List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), startDate);
                for (Transaction transaction : transactionList) {
                    //associate 필요
                    Associate associate = associateRepository.findByName(transaction.getStore())
                            .orElseThrow(() ->
                                    new RuntimeException());
                    //해당 소비 내역의 카테고리 코드가 해당 카테고리에 속하면
                    if (associate.getCategoryCode().equals(categoryCode)) {
                        //카테고리 소비 금액에 더해주기
                        categoryMonthlyConsume += transaction.getPrice();
                    }
                }
                startDate = startDate.plusDays(1);
            }
        }
        //전체 차지 비율
        BigDecimal percentageCategoryConsumeInEntireMonthlyConsume = getPercentageCategoryConsumeInEntireMonthlyConsume(monthlyConsume, categoryMonthlyConsume);

        return CategoryMonthlyConsumeDetails.from(categoryMonthlyConsume, percentageCategoryConsumeInEntireMonthlyConsume);
    }

    //카테고리별 소비 소비 정보 + 카테고리명
    public List<CategoryMonthlyConsumeDetailsWithCategorycode> getCategoryMonthlyConsumeDetailsWithCategorycode(int memberId, LocalDate localDate, int monthlyConsume){
        List<CategoryMonthlyConsumeDetailsWithCategorycode> categoryMonthlyConsumeDetailsWithCategorycodeList = new ArrayList<>();

        //전체 카테고리 내역 가지고 오기
        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        for(SubCommonCode subCommonCode : subCommonCodeList){
            String categoryCode = subCommonCode.getDetailCode();
            categoryMonthlyConsumeDetailsWithCategorycodeList.add(CategoryMonthlyConsumeDetailsWithCategorycode.from(categoryCode, getCategoryMonthlyConsumeDetails(memberId, localDate, monthlyConsume, categoryCode)));
        }

        return categoryMonthlyConsumeDetailsWithCategorycodeList;
    }

    //월별 카테고리별 소비 정보 가져오기
    public List<CategoryMonthlyConsumeWithMonthlyEntireConsume> getCategoryMonthlyConsumeWithMonthlyEntireConsume(int memberId){
        List<CategoryMonthlyConsumeWithMonthlyEntireConsume> categoryMonthlyConsumeWithMonthlyEntireConsumeList = new ArrayList<>();

        LocalDate localDate = MonthDay.JANUARY.toLocalDate();//1월부터 시작
        LocalDate startDate = localDate.withDayOfMonth(1); //1/1부터 시작
        LocalDate endDate = startDate.plusYears(1); //1년동안
        while(startDate.isBefore(endDate)){
            int month = startDate.getMonthValue();
            int monthlyConsume = getMonthlyConsume(memberId, startDate); //해당월의 총 소비금액
            categoryMonthlyConsumeWithMonthlyEntireConsumeList.add(CategoryMonthlyConsumeWithMonthlyEntireConsume.from(month, monthlyConsume, getCategoryMonthlyConsumeDetailsWithCategorycode(memberId, startDate, monthlyConsume)));
            startDate = startDate.plusMonths(1);
        }
        return categoryMonthlyConsumeWithMonthlyEntireConsumeList;
    }

    public CategoryMonthlyConsumeResponse getCategoryMonthlyConsumeResponse(int memberId){
        return CategoryMonthlyConsumeResponse.toResponse(memberId, getCategoryMonthlyConsumeWithMonthlyEntireConsume(memberId));
    }

    //카테고리 일별 소비내역
    public List<CategoryTransactionDetails> getCategoryTransactionDetails(int memberId, LocalDate localDate, String categoryCode){
        List<CategoryTransactionDetails> categoryTransactionDetailsList = new ArrayList<>();

        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList){
            //해당 일자 소비 내역 가져오기
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);
            for(Transaction transaction : transactionList){
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new RuntimeException());
                //카테고리 확인
                if(associate.getCategoryCode().equals(categoryCode)){
                    categoryTransactionDetailsList.add(CategoryTransactionDetails.from(transaction, associate));
                }
            }
        }
        return categoryTransactionDetailsList;
    }

    //카테고리 일별 소비내역
    public List<CategoryDailyTransaction> getCategoryDailyTransaction(int memberId, LocalDate localDate, String categoryCode){
        List<CategoryDailyTransaction> categoryDailyTransactionList = new ArrayList<>();

        LocalDate startDate = localDate;
        LocalDate endDate = startDate.plusMonths(1);
        while(startDate.isBefore(endDate)){
            List<CategoryTransactionDetails> categoryTransactionDetailsList = getCategoryTransactionDetails(memberId, startDate, categoryCode);
            if(categoryTransactionDetailsList.size() == 0){
                startDate = startDate.plusDays(1);
                continue;
            }
            categoryDailyTransactionList.add(CategoryDailyTransaction.from(startDate.getDayOfMonth(), categoryTransactionDetailsList));
            startDate = startDate.plusDays(1);
        }
        return categoryDailyTransactionList;
    }

    //카테고리 월별 소비내역
    public List<CategoryMonthlyTransaction> getCategoryMonthlyTransaction(int memberId, String categoryCode) {
        List<CategoryMonthlyTransaction> categoryMonthlyTransactionList = new ArrayList<>();

        LocalDate startDate = MonthDay.JANUARY.toLocalDate();
        startDate.withDayOfMonth(1);
        LocalDate endDate = startDate.plusYears(1);
        while(startDate.isBefore(endDate)){
            List<CategoryDailyTransaction> categoryDailyTransactionList = getCategoryDailyTransaction(memberId, startDate, categoryCode);
            if(categoryDailyTransactionList.size() == 0){
                startDate = startDate.plusMonths(1);
                continue;
            }
            categoryMonthlyTransactionList.add(CategoryMonthlyTransaction.from(startDate.getMonthValue(), categoryDailyTransactionList));
            startDate = startDate.plusMonths(1);
        }
        return categoryMonthlyTransactionList;
    }

    //카테고리 사용내역
    public List<CategoryEntireTransaction> getCategoryEntireTransaction(int memberId){
        List<CategoryEntireTransaction> categoryEntireTransactionList = new ArrayList<>();

        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        for(SubCommonCode subCommonCode : subCommonCodeList){
            String categorycode = subCommonCode.getDetailCode();
            List<CategoryMonthlyTransaction> categoryMonthlyTransactionList = getCategoryMonthlyTransaction(memberId, categorycode);
            if(categoryMonthlyTransactionList.size() == 0){
                continue;
            }
            categoryEntireTransactionList.add(CategoryEntireTransaction.from(categorycode, categoryMonthlyTransactionList));
        }
        return categoryEntireTransactionList;
    }

    public CategoryTransactionResponse getCategoryTransactionResponse(int memberId){
        return CategoryTransactionResponse.toResponse(memberId, getCategoryEntireTransaction(memberId));
    }
}
