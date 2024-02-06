package A803.cardian.settlement.controller;

import A803.cardian.goal.service.GoalService;
import A803.cardian.settlement.data.dto.response.SalaryUpdate;
import A803.cardian.settlement.service.SettlementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "연말정산 컨트롤러", description = "연말정산 관련 정보")
@RequestMapping("/api/settlement")
@RequiredArgsConstructor
@RestController
public class SettlementController {
    @Autowired
    private final  SettlementService settlementService;
    @Autowired
    private final GoalService goalService;
    @Operation(summary = "내 연봉 조회", description = "내 연봉 조회")
    @GetMapping("/{member_id}")
    public ResponseEntity<?> getMySalary(@PathVariable("member_id") Integer member_id){

        return ResponseEntity.ok(settlementService.findMySalary(member_id));
    }
    @Operation(summary = "내 연봉 정보 수정", description = "내 연봉 정보 수정")
    @PutMapping("/salary")
    public void updateSalary(@RequestBody SalaryUpdate salaryUpdate){

        settlementService.updateSalary(salaryUpdate.getMember_id(),salaryUpdate.getSalary());
    }
    @Operation(summary = "연말정산 기준 달성 여부 조회", description = "달성시 true, 미달성시 false")
    @GetMapping("/achievement-standard")
    public ResponseEntity<?> getAchieve(@RequestParam Integer memberId){

        return ResponseEntity.ok(goalService.getAchieve(memberId));
    }
    @Operation(summary = "연말정산 기준 미달성", description = "연말정산 기준 미달성시 보내줄 데이터")
    @GetMapping("/not-achievement")
    public ResponseEntity<?> getNotAchieveSettlement(@RequestParam Integer memberId){

        return ResponseEntity.ok(settlementService.settlementNotAchieve(memberId));
    }
    @Operation(summary = "연말정산 기준 달성", description = "연말정산 기준 달성시 보내줄 데이터")
    @GetMapping("/achievement")
    public ResponseEntity<?> getAchieveSettlement(@RequestParam Integer memberId){

        return ResponseEntity.ok(settlementService.settlementAchieve(memberId));
    }
}
