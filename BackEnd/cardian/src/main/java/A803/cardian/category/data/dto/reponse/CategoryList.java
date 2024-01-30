package A803.cardian.category.data.dto.reponse;

import A803.cardian.category.domain.SubCommonCode;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
public class CategoryList {
    private String categoryCode;
    private String categoryName;


    public SubCommonCode toEntity(){
        SubCommonCode build= SubCommonCode.builder()
                .detailCode(categoryCode)
                .name(categoryName)
                .build();
        return build;
    }
    @Builder
    public CategoryList(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }
}
