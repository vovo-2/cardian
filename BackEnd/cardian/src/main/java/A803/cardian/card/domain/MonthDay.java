package A803.cardian.card.domain;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
public enum MonthDay {
    JANUARY("2023-01-31"),
    FEBRUARY("2023-02-29"),
    MARCH("2023-03-31"),
    APRIL("2023-04-30"),
    MAY("2023-05-31"),
    JUNE("2023-06-30"),
    JULY("2023-07-31"),
    AUGUST("2023-08-31"),
    SEPTEMBER("2023-09-30"),
    OCTOBER("2023-10-31"),
    NOVEMBER("2023-11-30"),
    DECEMBER("2023-12-31")
    ;
    private final String value;

    public LocalDate toLocalDate(){
        return LocalDate.parse(value, DateTimeFormatter.ISO_DATE);
    }

}
