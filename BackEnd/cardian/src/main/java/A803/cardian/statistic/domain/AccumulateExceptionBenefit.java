package A803.cardian.statistic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccumulateExceptionBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false)
    private int myCardId;

    @Column(nullable = false, length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private int exceptionBenefitId;

    @Column(nullable = false)
    private int benefitAmount;

    public void updateBenefitAmount(int newBenefitAmount){
        this.benefitAmount = newBenefitAmount;
    }

    @Builder
    public AccumulateExceptionBenefit(int myCardId,
                                     String categoryCode,
                                     int exceptionBenefitId,
                                     int benefitAmount){
        this.myCardId = myCardId;
        this.categoryCode = categoryCode;
        this.exceptionBenefitId = exceptionBenefitId;
        this.benefitAmount = benefitAmount;
    }
}
