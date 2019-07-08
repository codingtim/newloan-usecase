package be.tim.codingtim.loan;

class LoanDenied implements LoanResponse {
    @Override
    public boolean isApproved() {
        return false;
    }

    @Override
    public InterestRate getInterestRate() {
        throw new IllegalArgumentException("A denied loan has no interest rate!");
    }
}
