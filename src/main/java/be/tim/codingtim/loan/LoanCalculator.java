package be.tim.codingtim.loan;

public interface LoanCalculator {
    InterestRate getQuote(LoanRequest loanRequest);
}
