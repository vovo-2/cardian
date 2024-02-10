package A803.cardian.card.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mycard_id")
    private MyCard myCard;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate day;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Column(nullable = false)
    private String store;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    private boolean status;

    @Column(nullable = false, columnDefinition = "tinyint(1)")
    private boolean discount;

    @Builder
    public Transaction(MyCard myCard, int number, LocalDate day, LocalDateTime date, String store,
                       int price, boolean status, boolean discount){
        this.myCard = myCard;
        this.number = number;
        this.day = day;
        this.date = date;
        this.store = store;
        this.price = price;
        this.status = status;
        this.discount = discount;
    }

}
