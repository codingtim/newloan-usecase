package be.tim.codingtim;

import be.tim.codingtim.credit.CreditRating;
import be.tim.codingtim.loan.LoanApproval;
import be.tim.codingtim.loan.LoanLender;
import be.tim.codingtim.loan.LoanRequest;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        LoanApproval loanApproval = loanLender.handle(loanRequest, ssnr -> new CreditRating(500));
        assertNotNull(loanApproval);
        assertTrue(loanApproval.isApproved());
    }

    @Test
    void whenContactInformationIsOkButCreditRatingIsTooLowThenReturnUnapproved() {
        LoanRequest loanRequest = new LoanRequest(
                new ContactInformation(
                        SocialSecurityNumber.of("123-45-6789"),
                        DateOfBirth.of(LocalDate.parse("1988-01-01"), Clock.systemUTC())
                )
        );
        LoanApproval loanApproval = loanLender.handle(loanRequest, ssnr -> new CreditRating(499));
        assertNotNull(loanApproval);
        assertFalse(loanApproval.isApproved());
    }
}
