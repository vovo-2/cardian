package A803.cardian.statistic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccumulateBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer cardId;

    @Column(nullable = false,length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private Integer benefitAmount;
}
