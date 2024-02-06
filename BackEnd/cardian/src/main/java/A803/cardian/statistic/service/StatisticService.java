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
import A803.cardian.statistic.data.dto.response.category.*;
import A803.cardian.statistic.data.dto.response.category.DailyTransactionDetails;
import A803.cardian.statistic.data.dto.response.category.MonthlyTransactionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;

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
    public List<A803.cardian.statistic.data.dto.response.DailyTransactionDetails> getDailyTransactionDetails(int memberId, LocalDate localDate) {
        List<A803.cardian.statistic.data.dto.response.DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();
        //내 카드 리스트 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);

        for (MyCard myCard : myCardList) {
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);

            for (Transaction transaction : transactionList) {
                //associate 필요
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new RuntimeException());
                dailyTransactionDetailsList.add(A803.cardian.statistic.data.dto.response.DailyTransactionDetails.from(transaction, associate));
            }
        }

        return dailyTransactionDetailsList;
    }

    //내 카드 전체 월별 소비 내역 조회 - 해당월만 조회
    public List<A803.cardian.statistic.data.dto.response.MonthlyTransactionDetails> getDailyTransactionDetailsWithDay(int memberId, LocalDate localDate) {
        List<A803.cardian.statistic.data.dto.response.MonthlyTransactionDetails> monthlyTransactionDetailsList = new ArrayList<>();

        LocalDate startDate = localDate;
        LocalDate endDate = localDate.plusMonths(1);
        while (startDate.isBefore(endDate)) {
            List<A803.cardian.statistic.data.dto.response.DailyTransactionDetails> dailyTransactionDetailsList = getDailyTransactionDetails(memberId, startDate);
            if (dailyTransactionDetailsList.size() == 0) { //내역 없으면 continue
                startDate = startDate.plusDays(1);
                continue;
            }
            //해당일의 사용내역 리스트
            monthlyTransactionDetailsList.add(A803.cardian.statistic.data.dto.response.MonthlyTransactionDetails.from(startDate.getDayOfMonth(), dailyTransactionDetailsList));
            startDate = startDate.plusDays(1);
            System.out.println("일별 사용 내역 : " + startDate);
        }
        return monthlyTransactionDetailsList;
    }

    //전체 월별 소비 내역 조회 - 전체 가져오기
    public EntireCardTransactionsResponse getEntireCardTransactionsResponse(int memberId) {
        List<YearTransactionDetails> yearTransactionDetailsList = new ArrayList<>();

        LocalDate startDate = MonthDay.JANUARY.toLocalDate(); //1월부터 (01-31)
        startDate = startDate.withDayOfMonth(1); //1일로 바꿔주기
        LocalDate endDate = startDate.plusYears(1);
        while (startDate.isBefore(endDate)) {
            //해당 월 사용내역 넣어주기
            yearTransactionDetailsList.add(YearTransactionDetails.from(startDate.getMonthValue(), getDailyTransactionDetailsWithDay(memberId, startDate)));
            startDate = startDate.plusMonths(1); //다음달로 바꾸어주기
            System.out.println(startDate + " 의 사용 내역");
        }
        return EntireCardTransactionsResponse.toResponse(memberId, yearTransactionDetailsList);
    }

    //전체 월 소비 금액에서 카테고리 소비금액이 차지하는 비율 계산
    public BigDecimal getPercentageCategoryConsumeInEntireMonthlyConsume(int entireMonthlyConsume, int categoryConsume) {
        double calResult = ((double) categoryConsume / entireMonthlyConsume) * 100;
        BigDecimal percentage = new BigDecimal(Double.toString(calResult));
        // 반올림 수행 (두 번째 매개변수는 반올림 자릿수, RoundingMode.HALF_UP은 반올림 방법)
        return percentage.setScale(2, RoundingMode.HALF_UP);
    }

    //카테고리별 월 총 소비 금액
    public int getMonthlyConsumePerCategory(int memberId, LocalDate localDate, String categoryCode) {
        //당월 카테고리 전체 소비 금액
        int MonthlyConsumePerCategory = 0;

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
                        MonthlyConsumePerCategory += transaction.getPrice();
                    }
                }
                startDate = startDate.plusDays(1);
            }
        }
        return MonthlyConsumePerCategory;
    }

    //카테고리별 소비 소비 정보 + 카테고리명
    public List<CategoryMonthlyConsumeDetails> getCategoryMonthlyConsumeDetailsWithCategorycode(int memberId, LocalDate localDate, int monthlyConsume){
        List<CategoryMonthlyConsumeDetails> categoryMonthlyConsumeDetailsList = new ArrayList<>();

        //전체 카테고리 내역 가지고 오기
        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        for(SubCommonCode subCommonCode : subCommonCodeList){
            String categoryCode = subCommonCode.getDetailCode();
            String categoryName = subCommonCode.getName();
            categoryMonthlyConsumeDetailsList.add(CategoryMonthlyConsumeDetails.from(categoryName, getMonthlyConsumePerCategory(memberId, localDate, categoryCode)));
        }

        //소비금액 내림차순 정렬
        Collections.sort(categoryMonthlyConsumeDetailsList, Comparator.comparingInt(CategoryMonthlyConsumeDetails::getMonthlyConsumePerCategory));

        return categoryMonthlyConsumeDetailsList;
    }

    //월별 카테고리별 소비 정보 가져오기
    public List<CategoryMonthlyConsume> getCategoryMonthlyConsumeWithMonthlyEntireConsume(int memberId){
        List<CategoryMonthlyConsume> categoryMonthlyConsumeList = new ArrayList<>();

        LocalDate localDate = MonthDay.JANUARY.toLocalDate();//1월부터 시작
        LocalDate startDate = localDate.withDayOfMonth(1); //1/1부터 시작
        LocalDate endDate = startDate.plusYears(1); //1년동안
        while(startDate.isBefore(endDate)){
            int month = startDate.getMonthValue();
            int monthlyConsume = getMonthlyConsume(memberId, startDate); //해당월의 총 소비금액
            categoryMonthlyConsumeList.add(CategoryMonthlyConsume.from(month, monthlyConsume, getCategoryMonthlyConsumeDetailsWithCategorycode(memberId, startDate, monthlyConsume)));
            startDate = startDate.plusMonths(1);
        }

        return categoryMonthlyConsumeList;
    }

    public CategoryMonthlyConsumeResponse getCategoryMonthlyConsumeResponse(int memberId){
        return CategoryMonthlyConsumeResponse.toResponse(memberId, getCategoryMonthlyConsumeWithMonthlyEntireConsume(memberId));
    }

    //카테고리 소비내역 상세
    public List<DailyTransactionDetails> getCategoryTransactionDetails(int memberId, LocalDate localDate, String categoryCode){
        List<DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();

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
                    dailyTransactionDetailsList.add(DailyTransactionDetails.from(transaction, associate));
                }
            }
        }
        return dailyTransactionDetailsList;
    }

    //카테고리 일별 소비내역
    public List<MonthlyTransactionDetails> getCategoryDailyTransaction(int memberId, LocalDate localDate, String categoryCode){
        List<MonthlyTransactionDetails> monthlyTransactionDetailsList = new ArrayList<>();

        LocalDate startDate = localDate;
        LocalDate endDate = startDate.plusMonths(1);
        while(startDate.isBefore(endDate)){
            List<DailyTransactionDetails> dailyTransactionDetailsList = getCategoryTransactionDetails(memberId, startDate, categoryCode);
            if(dailyTransactionDetailsList.size() == 0){
                startDate = startDate.plusDays(1);
                continue;
            }
            monthlyTransactionDetailsList.add(MonthlyTransactionDetails.from(startDate.getDayOfMonth(), dailyTransactionDetailsList));
            startDate = startDate.plusDays(1);
        }
        return monthlyTransactionDetailsList;
    }

    //카테고리 월별 소비내역
    public List<CategoryMonthlyTransaction> getCategoryMonthlyTransaction(int memberId, String categoryCode) {
        List<CategoryMonthlyTransaction> categoryMonthlyTransactionList = new ArrayList<>();

        LocalDate startDate = MonthDay.JANUARY.toLocalDate();
        startDate = startDate.withDayOfMonth(1);
        LocalDate endDate = startDate.plusYears(1);
        while(startDate.isBefore(endDate)){
            List<MonthlyTransactionDetails> monthlyTransactionDetailsList = getCategoryDailyTransaction(memberId, startDate, categoryCode);
            if(monthlyTransactionDetailsList.size() == 0){
                startDate = startDate.plusMonths(1);
                continue;
            }
            categoryMonthlyTransactionList.add(CategoryMonthlyTransaction.from(startDate.getMonthValue(), monthlyTransactionDetailsList));
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
            String categoryName = subCommonCode.getName();
            List<CategoryMonthlyTransaction> categoryMonthlyTransactionList = getCategoryMonthlyTransaction(memberId, categorycode);
            if(categoryMonthlyTransactionList.size() == 0){
                continue;
            }
            categoryEntireTransactionList.add(CategoryEntireTransaction.from(categoryName, categoryMonthlyTransactionList));
        }
        return categoryEntireTransactionList;
    }

    public CategoryTransactionResponse getCategoryTransactionResponse(int memberId){
        return CategoryTransactionResponse.toResponse(memberId, getCategoryEntireTransaction(memberId));
    }


    //상세내역 가져오기
    public List<CategoryDayTransactionDetails> getCategoryDayTransactionDetails(int memberId, LocalDate localDate, String categoryCode){
        List<CategoryDayTransactionDetails> categoryDayTransactionDetailList = new ArrayList<>();

        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for(MyCard myCard : myCardList){
            //해당 일자 소비 내역 가져오기
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);
            //없으면 다음 카드 보기
            if(transactionList.size() == 0){
                continue;
            }
            for(Transaction transaction : transactionList){
                Associate associate = associateRepository.findByName(transaction.getStore())
                        .orElseThrow(() ->
                                new RuntimeException());
                //카테고리 확인
                if(associate.getCategoryCode().equals(categoryCode)){
                    categoryDayTransactionDetailList.add(CategoryDayTransactionDetails.from(transaction, associate));
                }
            }
        }
        return categoryDayTransactionDetailList;
    }

    //카테고리별 일 소비내역 가지고 오기 (월 넘겨받음)
    public List<CategoryDayTransaction> getCategoryDayTransaction(int memberId, LocalDate localDate, String categoryName){
        List<CategoryDayTransaction> categoryDayTransactionList = new ArrayList<>();

        //카테고리이름으로 카테고리코드 가져오기
        SubCommonCode subCommonCode = subCommonCodeRepository.findByName(categoryName).get();
        String categoryCode = subCommonCode.getDetailCode();

        //해당월 소비내역 확인
        LocalDate startDate = localDate;
        LocalDate endDate = localDate.plusMonths(1);
        while(startDate.isBefore(endDate)){
            int day = startDate.getDayOfMonth();
            List<CategoryDayTransactionDetails> categoryDayTransactionDetailsList = getCategoryDayTransactionDetails(memberId, startDate, categoryCode);
            if (categoryDayTransactionDetailsList.size() == 0) {
                startDate = startDate.plusDays(1);
                continue;
            }
            //해당일의 상세내역 가져와서 넣어주기
            categoryDayTransactionList.add(CategoryDayTransaction.from(day, categoryDayTransactionDetailsList));
            startDate = startDate.plusDays(1);
        }

        return categoryDayTransactionList;
    }

    //카테고리별 월 소비내역 가지고 오기
    public List<CategoryTransaction> getCategoryTransaction(int memberId, int month){
        List<CategoryTransaction> categoryTransactionList = new ArrayList<>();

        //카테고리별
        List<SubCommonCode> subCommonCodeList = subCommonCodeRepository.findAll();
        for(SubCommonCode subCommonCode : subCommonCodeList){
            //카테고리 이름
            String categoryName = subCommonCode.getName();
            System.out.println(categoryName + "카테고리 계산 중");
            //카테고리 코드
            String categoryCode = subCommonCode.getDetailCode();

            //월 소비 내역
            List<MonthDay> monthDayList = Arrays.stream(MonthDay.values()).toList();
            LocalDate localDate = monthDayList.get(month - 1).toLocalDate().withDayOfMonth(1);
            System.out.println(localDate + "월입니다.");
            //일자별 가져오기
            //추후 테이블 사용으로 코드 변경
            categoryTransactionList.add(CategoryTransaction.from(categoryName, getMonthlyConsumePerCategory(memberId, localDate, categoryCode),getCategoryDayTransaction(memberId, localDate, categoryName)));
        }

        //내림차순으로 정렬
        Collections.sort(categoryTransactionList, Comparator.comparingInt(CategoryTransaction::getCategoryConsume).reversed());

        return categoryTransactionList;
    }

    /*
    //카테고리별 월 총 소비 금액
    public int getMonthlyConsumePerCategory(int memberId, LocalDate localDate, String categoryCode)
     */

    public CategoryMonthTransactionResponse getCategoryMonthTransactionResponse(int memberId, int month){
        return CategoryMonthTransactionResponse.toResponse(memberId, month, getCategoryTransaction(memberId, month));
    }
}
