package A803.cardian.statistic.service;

import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.service.TransactionService;
import A803.cardian.statistic.data.dto.response.MonthlyConsumeAmount;
import A803.cardian.statistic.data.dto.response.YearConsumeAmount;
import A803.cardian.statistic.data.dto.response.YearConsumeWithMonthlyConsumeResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Service
public class StatisticService {
    private final MycardRepository mycardRepository;
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
        int yearConsume = 0;

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
        yearConsume = january + february + march + april + may + june + july + august + september + october + november + december;

        YearConsumeAmount yearConsumeAmount = YearConsumeAmount.from(yearConsume, MonthlyConsumeAmount.from(january, february, march, april, may, june, july, august, september, october, november, december));

        return YearConsumeWithMonthlyConsumeResponse.toResponse(memberId, yearConsumeAmount);
    }

}
