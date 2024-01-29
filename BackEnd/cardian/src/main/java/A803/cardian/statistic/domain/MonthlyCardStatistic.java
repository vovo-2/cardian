package A803.cardian.statistic.domain;

import A803.cardian.card.domain.Company;
import A803.cardian.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MonthlyCardStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monthlycardstatistic_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private Integer cardId;

    @Column(nullable = false, length = 5)
    private String sort;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int month;

    @OneToMany(mappedBy = "monthlyCardStatistic")
    private List<CategoryMonthConsume> categoryMonthConsumes=new ArrayList<>();
}
