package A803.cardian.statistic.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccumulateBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int myCardId;

    @Column(nullable = false, length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private int benefitAmount;

    public void updateBenefitAmount(int benefitAmount){
        this.benefitAmount = benefitAmount;
    }

    @Builder
    public AccumulateBenefit(int myCardId,
                             String categoryCode,
                             int benefitAmount){
        this.myCardId = myCardId;
        this.categoryCode = categoryCode;
        this.benefitAmount = benefitAmount;
    }
}
