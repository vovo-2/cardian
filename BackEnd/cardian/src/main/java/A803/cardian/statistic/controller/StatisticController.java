package A803.cardian.statistic.controller;

import A803.cardian.statistic.data.dto.response.category.CategoryMonthlyConsumeResponse;
import A803.cardian.statistic.data.dto.response.category.CategoryTransactionResponse;
import A803.cardian.statistic.data.dto.response.EntireCardTransactionsResponse;
import A803.cardian.statistic.data.dto.response.YearConsumeWithMonthlyConsumeResponse;
import A803.cardian.statistic.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "통계 컨트롤러", description = "통계 관련 정보")
@RequestMapping("/api/statistic")
@RequiredArgsConstructor
@RestController
public class StatisticController {
    private final StatisticService statisticService;

    @Operation(summary = "올해 총 소비금액 조회", description = "올해 총 소비금액을 월별 소비금액과 함께 불러오는 API입니다.")
    @GetMapping("/{member_id}")
    public ResponseEntity<YearConsumeWithMonthlyConsumeResponse> getMyYearConsume(@PathVariable("member_id")int memberId){
        return ResponseEntity.ok(statisticService.getYearConsumeAmountWithMontlhlyConsume(memberId));
    }

    @Operation(summary = "전체 카드의 올해 월별,일별 사용 내역 조회", description = "전체 카드의 올해 사용내역을 월별, 일별로 불러오는 API입니다.")
    @GetMapping("/{member_id}/EntireCardTransaction")
    public ResponseEntity<EntireCardTransactionsResponse> getMyEntireCardTransactions(@PathVariable("member_id")int memberId){
        return ResponseEntity.ok(statisticService.getEntireCardTransactionsResponse(memberId));
    }

    @Operation(summary = "전체 카드의 카테고리별 올해 월별,일별 사용 금액 조회", description = "전체 카드의 올해 사용금액을 카테고리 별로 월별, 일별로 불러오는 API입니다.")
    @GetMapping("/{member_id}/CategoryMonthlyConsume")
    public ResponseEntity<CategoryMonthlyConsumeResponse> getCategoryMonthlyConsume(@PathVariable("member_id")int memberId){
        return ResponseEntity.ok(statisticService.getCategoryMonthlyConsumeResponse(memberId));
    }

    @Operation(summary = "전체 카드의 카테고리별 사용 내역 조회", description = "전체 카드의 카테고리별 사용 내역을 월별, 일별로 불러오는 API입니다.")
    @GetMapping("/{member_id}/CategoryTransaction")
    public ResponseEntity<CategoryTransactionResponse> getCategoryTransactionResponse(@PathVariable("member_id")int memberId){
        return ResponseEntity.ok(statisticService.getCategoryTransactionResponse(memberId));
    }
}
