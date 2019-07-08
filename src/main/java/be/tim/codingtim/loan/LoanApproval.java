package be.tim.codingtim.loan;

class LoanApproval implements LoanResponse {

    private InterestRate interestRate;

    LoanApproval(InterestRate interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean isApproved() {
        return true;
    }

    @Override
    public InterestRate getInterestRate() {
        return interestRate;
    }
}
