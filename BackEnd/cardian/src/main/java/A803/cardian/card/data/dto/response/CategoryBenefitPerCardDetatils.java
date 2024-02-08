package A803.cardian.card.data.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryBenefitPerCardDetatils {
    private String categoryCode;
    private int monthBenefit;

    private CategoryBenefitPerCardDetatils(String categoryCode, int monthBenefit) {
        this.categoryCode = categoryCode;
        this.monthBenefit = monthBenefit;
    }

    public static CategoryBenefitPerCardDetatils from(String categoryCode, int monthBenefit) {
        return new CategoryBenefitPerCardDetatils(categoryCode, monthBenefit);
    }
}
