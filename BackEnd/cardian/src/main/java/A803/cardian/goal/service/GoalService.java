package A803.cardian.goal.service;

import A803.cardian.Exception.ErrorCode;
import A803.cardian.Exception.ErrorException;
import A803.cardian.card.domain.Card;
import A803.cardian.card.domain.MonthDay;
import A803.cardian.card.domain.MyCard;
import A803.cardian.card.domain.Transaction;
import A803.cardian.card.repository.CardRepository;
import A803.cardian.card.repository.MycardRepository;
import A803.cardian.card.repository.TransactionRepository;
import A803.cardian.goal.data.dto.response.GoalAchieve;
import A803.cardian.goal.domain.Goal;
import A803.cardian.goal.repository.GoalRepository;
import A803.cardian.member.domain.Member;
import A803.cardian.member.repository.MemberRepository;
import A803.cardian.settlement.service.SettlementService;
import A803.cardian.statistic.domain.MonthlyCardStatistic;
import A803.cardian.statistic.repository.MonthlyCardStatisticRepository;
import A803.cardian.statistic.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    private final MonthlyCardStatisticRepository monthlyCardStatisticRepository;
    private final MemberRepository memberRepository;
    private final MycardRepository mycardRepository;
    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    public GoalAchieve getAchieve(Integer memberId){
        List<MonthlyCardStatistic> yearConsumeList=monthlyCardStatisticRepository.findByMember_Id(memberId);
        int yearConsume=0;
        for(MonthlyCardStatistic card:yearConsumeList){
            yearConsume+=card.getTotalPrice();
        }
        int salary=settlementService.findMySalary(memberId).getSalary();
        Boolean achieve;

        if(salary*0.25<yearConsume){
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


    public List<Transaction> findTransactionByMonth(MyCard myCard,int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        return transactionRepository.findTransactionsByMyCardAndDayBetween(myCard,startDate,endDate);
    }
    public List<Transaction> findTransactionByUpdateDate(MyCard myCard,int year, int month,int startDay) {
        LocalDate startDate = LocalDate.of(year, month, startDay);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);


        return transactionRepository.findTransactionsByMyCardAndDayBetween(myCard,startDate,endDate);
    }

    //실적테이블 값 추가
    public void saveGoal(int memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ErrorException(ErrorCode.NO_MEMBER));

        List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
        for (MyCard myCard : myCardList) {
            int lyear=LocalDate.now().getYear();
            int lastMonth =LocalDate.now().getMonthValue()-1;
            if(lastMonth==0){
                lastMonth=12;
                lyear-=1;
            }

            int year=LocalDate.now().getYear();
            int month =LocalDate.now().getMonthValue();
            List<Transaction> lastTransactionList=findTransactionByMonth(myCard,2023,11);

            List<Transaction> transactionList=findTransactionByMonth(myCard,2023,12);

            int lastConsume=0;
            int monthConsume=0;

            for(Transaction transaction:lastTransactionList){
                lastConsume+=transaction.getPrice();
            }
            for(Transaction transaction:transactionList){
                monthConsume+=transaction.getPrice();
            }

            Card c=cardRepository.findCardByMyCards(myCard);
            boolean tf=false;
            if(c.getGoal()<=lastConsume){
                tf=true;
            }

            Goal goal = Goal.builder()
                    .myCard(myCard)
                    .achieve(tf)
                    .accumulate(monthConsume)
                    .build();
            goalRepository.save(goal);


        }
    }

    //실적테이블 업데이트
    public void updateGoal(int memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ErrorException(ErrorCode.NO_MEMBER));
        LocalDateTime updateDate= LocalDateTime.from(member.getUpdateDate());
        LocalDateTime now=LocalDateTime.now();
        //최종 업데이트 시점과 다르면
        if(!updateDate.isEqual(now)){
            //같은 월이라면 누적만 바꿔주기
            if(updateDate.getMonthValue()==now.getMonthValue()){
                List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
                for (MyCard myCard : myCardList) {
                    int year=LocalDate.now().getYear();
                    int month =LocalDate.now().getMonthValue();
                    int monthConsume=0;
                    List<Transaction> transactionList =findTransactionByMonth(myCard,year,month);
                    for(Transaction transaction:transactionList){
                        monthConsume+=transaction.getPrice();
                    }
                    goalRepository.updateGoal(monthConsume,myCard.getId());
                }
            }else{
                List<MyCard> myCardList = mycardRepository.findMyCardsByMemberId(memberId);
                for (MyCard myCard : myCardList) {
                    int lyear=LocalDate.now().getYear();
                    int lastMonth =LocalDate.now().getMonthValue()-1;
                    if(lastMonth==0){
                        lastMonth=12;
                        lyear-=1;
                    }

                    int year=LocalDate.now().getYear();
                    int month =LocalDate.now().getMonthValue();
                    List<Transaction> lastTransactionList=findTransactionByMonth(myCard,lyear,lastMonth);

                    List<Transaction> transactionList=findTransactionByMonth(myCard,year,month);

                    int lastConsume=0;
                    int monthConsume=0;

                    for(Transaction transaction:lastTransactionList){
                        lastConsume+=transaction.getPrice();
                    }
                    for(Transaction transaction:transactionList){
                        monthConsume+=transaction.getPrice();
                    }

                    Card c=cardRepository.findCardByMyCards(myCard);
                    boolean tf=false;
                    if(c.getGoal()<=lastConsume){
                        tf=true;
                    }
                    goalRepository.updateGoalEntire(monthConsume,tf,myCard.getId());

                }
            }
        }
    }
}
