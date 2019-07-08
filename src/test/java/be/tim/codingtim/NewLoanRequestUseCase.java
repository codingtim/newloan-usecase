package be.tim.codingtim;

import be.tim.codingtim.credit.CreditRating;
import be.tim.codingtim.loan.InterestRate;
import be.tim.codingtim.loan.LoanLender;
import be.tim.codingtim.loan.LoanRequest;
import be.tim.codingtim.loan.LoanResponse;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class NewLoanRequestUseCase {

    private LoanLender loanLender = new LoanLender();

    @Test
    void whenContactInformationAndCreditRatingIsOkThenReturnLoanEstimation() {
        Clock clock = Clock.systemUTC();
        LoanRequest loanRequest = LoanRequest.of(
                new ContactInformation(
                        SocialSecurityNumber.of("123-45-6789"),
                        DateOfBirth.of(LocalDate.parse("1988-01-01"), clock)
                ), clock
        );
        LoanResponse response = loanLender.handle(
                loanRequest,
                ssnr -> new CreditRating(500),
                r -> new InterestRate(1.2d)
        );
        assertNotNull(response);
        assertTrue(response.isApproved());
        assertEquals(new InterestRate(1.2d), response.getInterestRate());
    }

    @Test
    void whenLoanRequestTooYoungThenReturnError() {
        Clock clock = Clock.fixed(Instant.parse("2018-07-08T00:00:00.000Z"), ZoneId.of("UTC"));
        assertThrows(IllegalArgumentException.class, () -> LoanRequest.of(
                new ContactInformation(
                        SocialSecurityNumber.of("123-45-6789"),
                        DateOfBirth.of(LocalDate.parse("2000-07-09"), clock)
                ), clock
        ));
    }

    @Test
    void whenContactInformationIsOkButCreditRatingIsTooLowThenReturnUnapproved() {
        Clock clock = Clock.systemUTC();
        LoanRequest loanRequest = LoanRequest.of(
                new ContactInformation(
                        SocialSecurityNumber.of("123-45-6789"),
                        DateOfBirth.of(LocalDate.parse("1988-01-01"), clock)
                ), clock
        );
        LoanResponse response = loanLender.handle(loanRequest,
                ssnr -> new CreditRating(499),
                r -> {
                    throw new RuntimeException("Get quote should not be called here");
                });
        assertNotNull(response);
        assertFalse(response.isApproved());
    }
}
