package A803.cardian.settlement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SettlementStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private int salary;

    @Column(nullable = false)
    private int low;

    @Column(nullable = false)
    private int high;

    @Column(nullable = false)
    private int max;
}
