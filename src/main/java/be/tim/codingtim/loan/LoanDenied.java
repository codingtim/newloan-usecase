package be.tim.codingtim.loan;

class LoanDenied implements LoanResponse {
    @Override
    public boolean isApproved() {
        return false;
    }
}
