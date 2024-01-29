package A803.cardian.associate.domain;

import A803.cardian.benefit.domain.CardCategoryMapping;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "associate_id")
    private Integer Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String categoryCode;

    @OneToMany(mappedBy = "associate")
    private List<CardCategoryMapping> cardCategoryMappings=new ArrayList<>();

}
