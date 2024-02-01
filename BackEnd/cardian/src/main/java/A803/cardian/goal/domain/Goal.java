package A803.cardian.goal.domain;

import A803.cardian.card.domain.MyCard;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "mycard_id")
    private MyCard myCard;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    private boolean achieve;

    @Column(nullable = false)
    private int accumulate;

}
