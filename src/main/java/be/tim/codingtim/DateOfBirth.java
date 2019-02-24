package be.tim.codingtim;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateOfBirth {

    private static final int THIRTEEN_YEARS = 13;
    private final LocalDate date;

    private DateOfBirth(LocalDate date) {
        this.date = date;
    }

    public static DateOfBirth of(LocalDate date, Clock clock) {
        if(ChronoUnit.YEARS.between(date, LocalDate.now(clock)) > THIRTEEN_YEARS) {
            return new DateOfBirth(date);
        } else {
            throw new IllegalArgumentException("Customers should be older than 13 years.");
        }
    }

    public LocalDate getDate() {
        return date;
    }
}
