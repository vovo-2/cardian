package A803.cardian.card.domain;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public enum MonthDay {
    JANUARY("2023-01-01"),
    FEBRUARY("2023-02-01"),
    MARCH("2023-03-01"),
    APRIL("2023-04-01"),
    MAY("2023-05-01"),
    JUNE("2023-06-01"),
    JULY("2023-07-01"),
    AUGUST("2023-08-01"),
    SEPTEMBER("2023-09-01"),
    OCTOBER("2023-10-01"),
    NOVEMBER("2023-11-01"),
    DECEMBER("2023-12-01")
    ;
    private final String value;

    public LocalDate toLocalDate(){
        return LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
    }

}
