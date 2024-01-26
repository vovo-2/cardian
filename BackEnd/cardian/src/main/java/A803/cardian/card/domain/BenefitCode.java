package A803.cardian.card.domain;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum BenefitCode {
    DISCOUNT("할인"),
    ACCUMULATE("적립"),
    CASHBACK("캐쉬백");

    private String value;

    BenefitCode(String value){
        this.value = value;
    }
}
