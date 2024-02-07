package A803.cardian.statistic.domain;

import A803.cardian.card.domain.Company;
import A803.cardian.card.domain.Type;
import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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
    private int consume;

    @Column(nullable = false)
    private int myCardId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private int month;

    public void updateConsume(int newConsume){
        this.consume = newConsume;
    }

    @Builder
    public CategoryMonthConsume(String categoryCode,
                                int consume,
                                int myCardId,
                                Type type,
                                int month){
        this.categoryCode = categoryCode;
        this.consume = consume;
        this.myCardId = myCardId;
        this.type = type;
        this.month = month;
    }
}
