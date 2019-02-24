package be.tim.codingtim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NewLoanRequestUseCase {

    private LoanLender loanLender = new LoanLender();

    @Test
    void whenContactInformationAndCreditRatingIsOkThenReturnLoadEstimation() {
        LoanRequest loanRequest = new LoanRequest(
                new ContactInformation()
        );
        LoanApproval loanApproval = loanLender.handle(loanRequest);
        assertNotNull(loanApproval);
    }
}
