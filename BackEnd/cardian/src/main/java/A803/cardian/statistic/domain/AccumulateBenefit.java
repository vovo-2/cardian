package A803.cardian.statistic.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccumulateBenefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int myCardId;

    @Column(nullable = false,length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private int benefitAmount;

}
