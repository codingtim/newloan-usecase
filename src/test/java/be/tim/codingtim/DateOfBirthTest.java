package be.tim.codingtim;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class DateOfBirthTest {

    @Test
    void validDateOfBirth() {
        ZoneId utc = ZoneId.of("UTC");
        Clock clock = Clock.fixed(LocalDate.of(2013, 01, 01).atStartOfDay(utc).toInstant(), utc);
        assertThrows(
                IllegalArgumentException.class,
                () -> DateOfBirth.of(LocalDate.parse("2000-01-01"), clock)
        );
    }

    @Test
    void customersShouldBeOlderThan13Years() {
        ZoneId utc = ZoneId.of("UTC");
        Clock clock = Clock.fixed(LocalDate.of(2012, 12, 31).atStartOfDay(utc).toInstant(), utc);
        assertThrows(
                IllegalArgumentException.class,
                () -> DateOfBirth.of(LocalDate.parse("2000-01-01"), clock)
        );
    }
}