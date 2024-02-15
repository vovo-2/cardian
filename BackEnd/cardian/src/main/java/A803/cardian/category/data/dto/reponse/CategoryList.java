package A803.cardian.category.data.dto.reponse;

import A803.cardian.category.domain.CategoryIcon;
import A803.cardian.category.domain.SubCommonCode;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryList {
    private String categoryCode;
    private String categoryName;


}
