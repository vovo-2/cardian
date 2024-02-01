package A803.cardian.settlement.service;

import A803.cardian.settlement.data.dto.response.MySalary;
import A803.cardian.settlement.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SettlementService {
    @Autowired
    private final SettlementRepository settlementRepository;


    public MySalary findMySalary(String memberId){
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
}
