package A803.cardian.category.controller;

import A803.cardian.card.service.CardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "검색 컨트롤러", description = "검색 관련 정보")
@RequestMapping("/search")
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private final CardService cardService;

//    public ResponseEntity<> getCategories(){
//
//    }
}
