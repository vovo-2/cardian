package A803.cardian.category.domain;

import A803.cardian.card.domain.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SubCommonCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 3)
    private String mainCode;

    @Column(nullable = false,length = 6)
    private String detailCode;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 100)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_id")
    private MainCommomCode mainCommomCode;
}
