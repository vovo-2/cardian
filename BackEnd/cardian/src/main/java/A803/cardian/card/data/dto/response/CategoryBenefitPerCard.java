package A803.cardian.card.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerCard {
    private int myCardId;
    private List<CategoryBenefitPerCardDetatils> categoryBenefitPerCardDetatilsList;

    private CategoryBenefitPerCard(int myCardId, List<CategoryBenefitPerCardDetatils> categoryBenefitPerCardDetatilsList){
        this.myCardId = myCardId;
        this.categoryBenefitPerCardDetatilsList = categoryBenefitPerCardDetatilsList;
    }

    public static CategoryBenefitPerCard from(int myCardId, List<CategoryBenefitPerCardDetatils> categoryBenefitPerCardDetatilsList){
        return new CategoryBenefitPerCard(myCardId, categoryBenefitPerCardDetatilsList);
    }
}
