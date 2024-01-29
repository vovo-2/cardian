package A803.cardian.benefit.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionBenfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 10)
    private String categoryCode;

    @Column(nullable = false)
    private int associateId;

    @Column(nullable = false)
    private int companyId;

    @Column(nullable = false)
    private int cardId;

    @Column(nullable = false)
    private int discountLine;

    @Column(nullable = false)
    private int discountAmount;

    @Column(nullable = false,length = 5)
    private String sign;

    @Column(nullable = false)
    private int discountLimit;
}
