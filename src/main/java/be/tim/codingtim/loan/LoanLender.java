package be.tim.codingtim.loan;

import be.tim.codingtim.credit.CreditRater;
import be.tim.codingtim.credit.CreditRating;

public class LoanLender {

    public LoanResponse handle(LoanRequest loanRequest, CreditRater creditRater, LoanCalculator loanCalculator) {
        CreditRating rating = creditRater.rate(loanRequest.getSocialSecurityNumber());
        if(rating.isRatingEqualToOrAbove(500)) {
            return new LoanApproval(loanCalculator.getQuote(loanRequest));
        } else {
            return new LoanDenied();
        }
    }
}
