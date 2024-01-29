package A803.cardian.statistic.domain;

import A803.cardian.card.domain.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryMonthConsume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private Integer consume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthlycardstatistic_id")
    private MonthlyCardStatistic monthlyCardStatistic;
}
