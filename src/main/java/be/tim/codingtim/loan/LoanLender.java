package be.tim.codingtim.loan;

import be.tim.codingtim.credit.CreditRater;
import be.tim.codingtim.credit.CreditRating;

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
