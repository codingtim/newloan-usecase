package be.tim.codingtim;

public class LoanLender {

    public LoanApproval handle(LoanRequest loanRequest, CreditRater creditRater) {
        //TODO only people above 18 are allowed to request loans
        CreditRating rating = creditRater.rate(loanRequest.getSocialSecurityNumber());
        if(rating.isRatingEqualToOrAbove(500)) {
            //TODO add estimation
            return LoanApproval.approved();
        } else {
            return LoanApproval.notApproved();
        }
    }
}
