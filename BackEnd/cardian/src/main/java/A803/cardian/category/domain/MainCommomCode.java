package A803.cardian.category.domain;

import A803.cardian.card.domain.Company;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MainCommomCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "main_id")
    private Integer id;

    @Column(nullable = false,length = 3)
    private String code;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 100)
    private String description;

    @OneToMany(mappedBy = "mainCommomCode")
    private List<SubCommonCode> subCommonCodes=new ArrayList<>();

}
