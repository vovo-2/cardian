package A803.cardian.member.domain;

import A803.cardian.associate.domain.Associate;
import A803.cardian.card.domain.FavoriteCard;
import A803.cardian.card.domain.MyCard;
import A803.cardian.member.domain.embbeded.PhoneNumber;
import A803.cardian.settlement.domain.Settlement;
import A803.cardian.settlement.domain.SettlementStandard;
import A803.cardian.statistic.domain.CategoryMonthConsume;
import A803.cardian.statistic.domain.MonthlyCardStatistic;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @Column(nullable = false)
    private Integer cardMemberId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private int age;

    @Embedded
    @Column(nullable = false, length = 11)
    private PhoneNumber phoneNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MonthlyCardStatistic> monthlyCardStatistics = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MyCard> myCards = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<FavoriteCard> favoriteCards = new ArrayList<>();

    @OneToOne(mappedBy = "member")
    private Certificate certificate;

    @OneToOne(mappedBy = "member")
    private Settlement settlement;
    @Builder
    public Member(String name,
                  LocalDate birth,
                  Gender gender,
                  int age,
                  PhoneNumber phoneNumber,
                  LocalDateTime updateDate
                  ){
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.updateDate = updateDate;
    }
}
