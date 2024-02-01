package A803.cardian.statistic.controller;

import A803.cardian.statistic.data.dto.response.YearConsumeWithMonthlyConsumeResponse;
import A803.cardian.statistic.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "통계 컨트롤러", description = "통계 관련 정보")
@RequestMapping("/statistic")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class StatisticController {
    private final StatisticService statisticService;

    @Operation(summary = "올해 총 소비금액 조회", description = "올해 총 소비금액을 월별 소비금액과 함께 불러오는 API입니다.")
    @GetMapping("/{member_id}")
    public ResponseEntity<YearConsumeWithMonthlyConsumeResponse> getMyYearConsume(@PathVariable("member_id")int memberId){
        return ResponseEntity.ok(statisticService.getYearConsumeAmountWithMontlhlyConsume(memberId));
    }
}
