package A803.cardian.settlement.controller;

import A803.cardian.goal.service.GoalService;
import A803.cardian.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "연말정산 컨트롤러", description = "연말정산 관련 정보")
@RequestMapping("/settlement")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class SettlementController {
    @Autowired
    private final  SettlementService settlementService;
    @Autowired
    private final GoalService goalService;
    @GetMapping("/{member_id}")
    public ResponseEntity<?> getMySalary(@PathVariable("member_id") Integer member_id){

        return ResponseEntity.ok(settlementService.findMySalary(member_id));
    }

    @PutMapping("/salary")
    public void updateSalary(@RequestParam(value = "member_id") Integer member_id, @RequestParam Integer salary){

        settlementService.updateSalary(member_id,salary);
    }

    @GetMapping("/achievement-standard")
    public ResponseEntity<?> getAchieve(@RequestParam Integer memberId){

        return ResponseEntity.ok(goalService.getAchieve(memberId));
    }

    @GetMapping("/not-achievement")
    public ResponseEntity<?> getNotAchieveSettlement(@RequestParam Integer memberId){

        return ResponseEntity.ok(settlementService.settlementNotAchieve(memberId));
    }

//    @GetMapping("/achievement-standard")
//    public ResponseEntity<?> getAchieve(@RequestParam Integer myCardId){
//
//        return ResponseEntity.ok(goalService.getAchieve(myCardId));
//    }
}