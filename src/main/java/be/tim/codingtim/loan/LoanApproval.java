package be.tim.codingtim.loan;

public class LoanApproval {
    private boolean approved;

    private LoanApproval(boolean approved) {
        this.approved = approved;
    }

    static LoanApproval approved() {
        return new LoanApproval(true);
    }

    static LoanApproval notApproved() {
        return new LoanApproval(false);
    }

    public boolean isApproved() {
        return approved;
    }
}
