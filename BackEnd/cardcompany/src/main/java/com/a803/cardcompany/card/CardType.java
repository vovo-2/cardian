package com.a803.cardcompany.card;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum CardType {
    CREDIT("신용"),
    CHECK("체크");

    private String value;

    CardType(String value){
        this.value = value;
    }
}

