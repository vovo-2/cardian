package A803.cardian.settlement.service;

import A803.cardian.card.domain.MyCard;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.service.CardService;
import A803.cardian.card.service.TransactionService;
import A803.cardian.settlement.data.dto.response.MySalary;
import A803.cardian.settlement.data.dto.response.SettlementNotAchieve;
import A803.cardian.settlement.data.dto.response.YearConsume;
import A803.cardian.settlement.repository.SettlementRepository;
import A803.cardian.statistic.domain.MonthlyCardStatistic;
import A803.cardian.statistic.repository.MonthlyCardStatisticRepository;
import A803.cardian.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SettlementService {
    @Autowired
    private final SettlementRepository settlementRepository;
    @Autowired
    private final StatisticService statisticService;
    @Autowired
    private final CardService cardService;
    @Autowired
    private final TransactionService transactionService;
    @Autowired
    private final MycardRepository mycardRepository;
    @Autowired
    private final MonthlyCardStatisticRepository monthlyCardStatisticRepository;


    public MySalary findMySalary(Integer memberId){
        Integer salary= settlementRepository.findByMember_Id(memberId).orElse(null);
        MySalary mySalary=MySalary.builder()
                .salary(salary)
                .build();

        return mySalary;
    }

    @Transactional
    public void updateSalary(Integer member_id, Integer salary) {
        System.out.println("memberid: "+member_id+" Salary: "+salary);
        settlementRepository.updateSalary(member_id,salary);
    }


//    public int getMonthlyCreditConsume(int memberId, LocalDate localDate){
//        int monthlyConsume = 0;
//        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
//        //당월 1일로 바꿔주기
//        if(localDate.getDayOfMonth() != 1){
//            localDate = localDate.withDayOfMonth(1);
//        }
//        for(MyCard myCard : myCardList){
//            int myCardId = myCard.getId();
//            monthlyConsume += transactionService.getMonthlyAccumulate(myCardId, localDate);
//        }
//        System.out.println("월별 소비 금액 : " + localDate + " " +monthlyConsume);
//        return monthlyConsume;
//    }

    public SettlementNotAchieve settlementNotAchieve(Integer memberId){
        int yearConsume=statisticService.getYearConsumeAmountWithMontlhlyConsume(memberId).getYearConsumeAmount().getYearConsumeAmount();
        int salary=findMySalary(memberId).getSalary();
        int standard= (int) (salary*0.25);
        List<MonthlyCardStatistic> yearConsumeList= monthlyCardStatisticRepository.findByMember_Id(memberId);
        int checkConsume=0;
        int creditConsume=0;
        for(MonthlyCardStatistic check: yearConsumeList){
            if(check.getSort().equals("체크")){
                checkConsume+=check.getTotalPrice();
            }else{
                creditConsume+=check.getTotalPrice();
            }
        }


        SettlementNotAchieve settlementNotAchieve=SettlementNotAchieve.builder()
                .annualConsume(yearConsume)
                .annualCheckConsume(checkConsume)
                .annualCreditConsume(creditConsume)
                .settlementStandard(standard)
                .build();

        return settlementNotAchieve;
    }




}
