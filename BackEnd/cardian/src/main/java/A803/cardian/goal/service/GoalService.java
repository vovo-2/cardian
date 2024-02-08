package A803.cardian.goal.service;

import A803.cardian.goal.data.dto.response.GoalAchieve;
import A803.cardian.goal.repository.GoalRepository;
import A803.cardian.settlement.service.SettlementService;
import A803.cardian.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class GoalService {
    @Autowired
    private final GoalRepository goalRepository;
    @Autowired
    private final StatisticService statisticService;
    @Autowired
    private final SettlementService settlementService;
    public GoalAchieve getAchieve(Integer memberId){
        //int yearConsume=statisticService.getYearConsumeAmountWithMontlhlyConsume(memberId).getYearConsumeAmount().getYearConsumeAmount();
        int salary=settlementService.findMySalary(memberId).getSalary();
        Boolean achieve;

        if(salary*0.25<14719500){
            achieve=true;
        }else{
            achieve=false;
        }

        GoalAchieve goalAchieve=GoalAchieve.builder()
                .achieve(achieve)
                .build();

        return goalAchieve;
    }

    public boolean getCardGoalAchieve(Integer myCardId){
        Optional<Boolean> tf = goalRepository.findByMyCard_Id(myCardId);



        return tf.get().booleanValue();
    }
}
