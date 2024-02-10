package A803.cardian.statistic.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class AccumulateCategoryBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int myCardId;

    @Column(nullable = false, length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private int categoryBenefitId;

    @Column(nullable = false)
    private int benefitAmount;

    public void updateBenefitAmount(int newBenefitAmount){
        this.benefitAmount = newBenefitAmount;
    }

    @Builder
    public AccumulateCategoryBenefit(int myCardId,
                                      String categoryCode,
                                      int categoryBenefitId,
                                      int benefitAmount){
        this.myCardId = myCardId;
        this.categoryCode = categoryCode;
        this.categoryBenefitId = categoryBenefitId;
        this.benefitAmount = benefitAmount;
    }
}
