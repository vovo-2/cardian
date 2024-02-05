package A803.cardian.reocommendation.controller;

import A803.cardian.reocommendation.data.dto.response.CardRecommendationResponse;
import A803.cardian.reocommendation.service.RecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "추천 컨트롤러", description = "카드 추천 기능")
@RequestMapping("/recommendation")
@RequiredArgsConstructor
@RestController
public class RecommendationController {
    private final RecommendationService recommendationService;

    @Operation(summary = "카테고리별 카드 추천", description = "카테고리별로 카드를 추천해주는 API입니다.")
    @GetMapping("/{member_id}/{category_name}")
    public ResponseEntity<CardRecommendationResponse> recommendCard(@PathVariable("member_id") int memberId, @PathVariable("category_name") String categoryName){
        return ResponseEntity.ok(recommendationService.getCardRecommendationResponse(memberId, categoryName));
    }
}
