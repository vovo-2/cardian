package A803.cardian.category.data.dto.reponse;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryListImage {
    private String categoryCode;
    private String categoryName;
    private String categoryImage;

}
