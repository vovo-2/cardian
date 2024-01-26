package A803.cardian.card.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum Type {
    CREDIT("신용"),
    CHECK("체크");

    private String value;

    Type(String value){
        this.value = value;
    }
}
