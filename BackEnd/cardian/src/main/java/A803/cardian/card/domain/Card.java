package A803.cardian.card.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false, name = "carddb_id")
    private Integer cardDatabaseId;

    @Enumerated(EnumType.STRING)
//    @Convert(converter = TypeConverter.class)
    private Type type;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 400)
    private String image;

    @Column(nullable = false)
    private int goal;

    @Column(nullable = false)
    private int annualfee;

    @Enumerated(EnumType.STRING)
//    @Convert(converter = BenefitCodeConverter.class)
    private BenefitCode benefitCode;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
    private List<MyCard> myCards = new ArrayList<>();

    @Builder
    public Card(Company company,
                Integer cardDatabaseId,
                Type type,
                String name,
                String image,
                int goal,
                int annualfee,
                BenefitCode benefitCode){
        this.company = company;
        this.cardDatabaseId = cardDatabaseId;
        this.type = type;
        this.name = name;
        this.image = image;
        this.goal = goal;
        this.annualfee = annualfee;
        this.benefitCode = benefitCode;
    }
}
