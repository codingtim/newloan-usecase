package be.tim.codingtim;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NewLoanRequestUseCase {

    private LoanLender loanLender = new LoanLender();

    @Test
    void whenContactInformationAndCreditRatingIsOkThenReturnLoanEstimation() {
        LoanRequest loanRequest = new LoanRequest(
                new ContactInformation(
                        SocialSecurityNumber.of("123-45-6789"),
                        DateOfBirth.of(LocalDate.parse("1988-01-01"), Clock.systemUTC())
                )
        );
        LoanApproval loanApproval = loanLender.handle(loanRequest);
        assertNotNull(loanApproval);
    }
}
