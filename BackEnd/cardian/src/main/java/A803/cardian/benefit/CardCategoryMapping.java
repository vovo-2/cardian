package A803.cardian.benefit;

import A803.cardian.associate.domain.Associate;
import A803.cardian.card.domain.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CardCategoryMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associate_id")
    private Associate associate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorybenefit_id")
    private CategoryBenefit categoryBenefit;

    @Column(nullable = false)
    private int cardId;

    @Column(nullable = false,length = 10)
    private String categoryCode;
}

