package A803.cardian.reocommendation.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "추천 컨트롤러", description = "카드 추천 기능")
@RequestMapping("/recommendation")
@RequiredArgsConstructor
@RestController
public class recommendationController {

}
