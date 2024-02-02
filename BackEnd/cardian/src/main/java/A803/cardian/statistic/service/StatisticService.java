package A803.cardian.statistic.service;

import A803.cardian.associate.domain.Associate;
import A803.cardian.associate.repository.AssociateRepository;
import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Transaction;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.card.service.TransactionService;
import A803.cardian.statistic.data.dto.response.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StatisticService {
    private final MycardRepository mycardRepository;
    private final TransactionRepository transactionRepository;
    private final AssociateRepository associateRepository;
    private final TransactionService transactionService;

    //전체 카드 월별 소비금액
    public int getMonthlyConsume(int memberId, LocalDate localDate){
        int monthlyConsume = 0;
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        //당월 1일로 바꿔주기
        if(localDate.getDayOfMonth() != 1){
            localDate = localDate.withDayOfMonth(1);
        }
        for(MyCard myCard : myCardList){
            int myCardId = myCard.getId();
            monthlyConsume += transactionService.getMonthlyAccumulate(myCardId, localDate);
        }
        System.out.println("월별 소비 금액 : " + localDate + " " +monthlyConsume);
        return monthlyConsume;
    }

    //전체 카드 연간 소비금액 (월별 소비금액 합)
    public int getYearConsume(int memberId){
        int yearConsume = 0;
        LocalDate localDate = MonthDay.JANUARY.toLocalDate();
        LocalDate endDate = localDate.plusYears(1);
        while(localDate.isBefore(endDate)) {
            yearConsume += getMonthlyConsume(memberId, localDate); //월별 소비금액 더해주기
            System.out.println(" 현재 더해진 월 :  " + localDate);
            endDate = endDate.plusMonths(1);
        }
        System.out.println("총합 : " + yearConsume);
        return yearConsume;
    }

    //올해 총 소비 금액 + 월별 소비금액
    public YearConsumeWithMonthlyConsumeResponse getYearConsumeAmountWithMontlhlyConsume(int memberId){
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


    //내 카드 전레 사용내역을 일자별로 가져오기
    public List<DailyTransactionDetails> getDailyTransactionDetails(int memberId, LocalDate localDate) {
        List<DailyTransactionDetails> dailyTransactionDetailsList = new ArrayList<>();
        //내 카드 리스트 가져오기
        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);

        for(MyCard myCard : myCardList){
            List<Transaction> transactionList = transactionRepository.findTransactionsByMyCardIdAndDay(myCard.getId(), localDate);

            for(Transaction transaction : transactionList){
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
    public List<DailyTransactionDetailsWithDay> getDailyTransactionDetailsWithDay(int memberId, LocalDate localDate){
        List<DailyTransactionDetailsWithDay> dailyTransactionDetailsWithDayList = new ArrayList<>();

//        LocalDate startDate = localDate.withDayOfMonth(1); //1일부터 조회
//        LocalDate endDate = startDate.plusMonths(1);//다음달 1일
        LocalDate startDate = localDate;
        LocalDate endDate = localDate.plusMonths(1);
        while(startDate.isBefore(endDate)){
            List<DailyTransactionDetails> dailyTransactionDetailsList = getDailyTransactionDetails(memberId, startDate);
            if(dailyTransactionDetailsList.size() == 0){ //내역 없으면 continue
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
    public EntireCardTransactionsResponse getEntireCardTransactionsResponse(int memberId){
        List<MonthlyTransactionDetailsWithMonth> monthlyTransactionDetailsWithMonthList = new ArrayList<>();

        LocalDate startDate = MonthDay.JANUARY.toLocalDate(); //1월부터 (01-31)
        startDate = startDate.withDayOfMonth(1); //1일로 바꿔주기
        LocalDate endDate = startDate.plusYears(1);
        while(startDate.isBefore(endDate)){
            //해당 월 사용내역 넣어주기
            monthlyTransactionDetailsWithMonthList.add(MonthlyTransactionDetailsWithMonth.from(startDate.getMonthValue(), getDailyTransactionDetailsWithDay(memberId, startDate)));
            startDate = startDate.plusMonths(1); //다음달로 바꾸어주기
            System.out.println(startDate + " 의 사용 내역");
        }
        return EntireCardTransactionsResponse.toResponse(memberId, monthlyTransactionDetailsWithMonthList);
    }

}
