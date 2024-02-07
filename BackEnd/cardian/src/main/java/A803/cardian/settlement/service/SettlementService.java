package A803.cardian.settlement.service;

import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Type;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.service.CardService;
import A803.cardian.card.service.TransactionService;
import A803.cardian.settlement.data.dto.response.MySalary;
import A803.cardian.settlement.data.dto.response.SettlementAchieve;
import A803.cardian.settlement.data.dto.response.SettlementNotAchieve;
import A803.cardian.settlement.data.dto.response.YearConsume;
import A803.cardian.settlement.domain.SettlementStandard;
import A803.cardian.settlement.repository.SettlementRepository;
import A803.cardian.settlement.repository.SettlementStandardRepository;
import A803.cardian.statistic.domain.MonthlyCardStatistic;
import A803.cardian.statistic.repository.MonthlyCardStatisticRepository;
import A803.cardian.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SettlementService {
    @Autowired
    private final SettlementRepository settlementRepository;
    @Autowired
    private final StatisticService statisticService;
    @Autowired
    private final MonthlyCardStatisticRepository monthlyCardStatisticRepository;
    @Autowired
    private final SettlementStandardRepository settlementStandardRepository;

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


    public SettlementNotAchieve settlementNotAchieve(Integer memberId){
        int yearConsume=statisticService.getYearConsumeAmountWithMontlhlyConsume(memberId).getYearConsumeAmount().getYearConsumeAmount();
        int salary=findMySalary(memberId).getSalary();
        int standard= (int) (salary*0.25);
        List<MonthlyCardStatistic> yearConsumeList= monthlyCardStatisticRepository.findByMember_Id(memberId);
        int checkConsume=0;
        int creditConsume=0;
        for(MonthlyCardStatistic check: yearConsumeList){
            if(check.getType().equals(Type.CHECK)){
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

    public SettlementAchieve settlementAchieve(Integer memberId){

        int salary=findMySalary(memberId).getSalary();
        int maxSettlemnet=0;
        int mySettlement=0;
        int standardSalary= (int) (salary*0.25);

        List<SettlementStandard> standard = settlementStandardRepository.findAll();

        List<MonthlyCardStatistic> yearConsumeList= monthlyCardStatisticRepository.findByMember_Id(memberId);
        int checkConsume=0;
        int creditConsume=0;
        for(MonthlyCardStatistic check: yearConsumeList){
            if(check.getType().equals(Type.CHECK)){
                checkConsume+=check.getTotalPrice();
            }else{
                creditConsume+=check.getTotalPrice();
            }
        }

        if(salary>standard.get(0).getSalary()){
            maxSettlemnet=standard.get(0).getHigh();
        }else{
            if(salary*((double)standard.get(0).getMax()/100)<standard.get(0).getLow()){
                maxSettlemnet= (int) (salary*((double)standard.get(0).getMax()/100));
            }else{
                maxSettlemnet=standard.get(0).getLow();
            }
        }

        int dupliCheck=checkConsume;
        int dupliCredit=creditConsume;
        int dupliMaxSettle=maxSettlemnet;

        if(dupliCredit>standardSalary){
            dupliCredit-=standardSalary;
            if(dupliCredit*0.15>=maxSettlemnet){
                mySettlement=maxSettlemnet;
            }else{
                mySettlement+=dupliCredit*0.15;
                dupliMaxSettle-=dupliCredit*0.15;
                if(dupliCheck*0.3>=dupliMaxSettle){
                    mySettlement=maxSettlemnet;
                }else{
                    mySettlement+=dupliCheck*0.3;
                }
            }
        }else{
            standardSalary-=dupliCredit;
            dupliCredit=0;
            dupliCheck-=standardSalary;
            if(dupliCredit*0.15>=maxSettlemnet){
                mySettlement=maxSettlemnet;
            }else{
                mySettlement+=dupliCredit*0.15;
                dupliMaxSettle-=dupliCredit*0.15;
                if(dupliCheck*0.3>=dupliMaxSettle){
                    mySettlement=maxSettlemnet;
                }else{
                    mySettlement+=dupliCheck*0.3;
                }
            }
        }



        SettlementAchieve settlementAchieve=SettlementAchieve.builder()
                .annualCheckConsume(checkConsume)
                .annualCreditConsume(creditConsume)
                .maxSettlement(maxSettlemnet)
                .mySettlement(mySettlement)
                .build();

        return settlementAchieve;
    }




}
