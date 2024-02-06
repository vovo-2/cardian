package A803.cardian.category.controller;

import A803.cardian.associate.data.dto.response.AssociationList;
import A803.cardian.associate.data.dto.response.Search;
import A803.cardian.associate.service.AssociateService;
import A803.cardian.category.data.dto.reponse.CategoryList;
import A803.cardian.category.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "검색 컨트롤러", description = "검색 관련 정보")
@RequestMapping("/api/search")
@RequiredArgsConstructor
@RestController
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final AssociateService associateService;
    @Operation(summary = "카테고리 조회", description = "카테고리 리스트 출력")
    @GetMapping("/category")
    public ResponseEntity<?> getCategories(){

        return ResponseEntity.ok(categoryService.findAllCategory());
    }
    @Operation(summary = "카테고리 별 제휴사 조회", description = "카테고리 별 제휴사 리스트 출력")
    @GetMapping("/{category_code}/association")
    public ResponseEntity<?> getSelectCategory(@PathVariable("category_code") String categoryCode){

        return ResponseEntity.ok(associateService.findAssociation(categoryCode));
    }
    @Operation(summary = "카테고리+이미지 조회", description = "카테고리 목록+이미지 출력")
    @GetMapping("/category-image")
    public ResponseEntity<?> getCategoryImage(){

        return ResponseEntity.ok(categoryService.findAllCategoryImage());
    }
    @Operation(summary = "제휴사 검색", description = "제휴사 검색")
    @PostMapping("/association")
    public ResponseEntity<?> searchAssociation(@RequestBody Search search){
        return ResponseEntity.ok(associateService.searchAssociation(search));
    }
    @Operation(summary = "선택한 제휴사 별 카드 추천", description = "선택한 제휴사에 대해 가장 좋은 혜택을 가진 카드부터 출력")
    @GetMapping("/{member_id}/{associate_id}/card-list")
    public ResponseEntity<?> categoryCardRecommend(@PathVariable("member_id")int memberId,@PathVariable("associate_id")int associateId){
        return ResponseEntity.ok(categoryService.categoryCardRecommend(memberId,associateId));
    }
}
