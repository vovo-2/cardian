package A803.cardian.statistic.data.dto.response;

import A803.cardian.card.domain.MyCard;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

//카드별
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CategoryMonthConsumePerMyCard {
    private MyCard myCard;
    private List<CategoryMonthConsumePerCategory> categoryMonthConsumePerCategoryList;

    private CategoryMonthConsumePerMyCard(MyCard myCard, List<CategoryMonthConsumePerCategory> categoryMonthConsumePerCategoryList){
        this.myCard = myCard;
        this.categoryMonthConsumePerCategoryList = categoryMonthConsumePerCategoryList;
    }

    public static CategoryMonthConsumePerMyCard from(MyCard myCard, List<CategoryMonthConsumePerCategory> categoryMonthConsumePerCategoryList){
        return new CategoryMonthConsumePerMyCard(myCard, categoryMonthConsumePerCategoryList);
    }
}
