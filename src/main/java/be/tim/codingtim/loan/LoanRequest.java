package be.tim.codingtim.loan;

import be.tim.codingtim.ContactInformation;
import be.tim.codingtim.SocialSecurityNumber;

import java.time.Clock;

public class LoanRequest {
    private ContactInformation contactInformation;

    private LoanRequest(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public static LoanRequest of(ContactInformation contactInformation, Clock clock) {
        if(contactInformation.getAge(clock) < 18) throw new IllegalArgumentException("Loans are only allowed for people older than 18 years.");
        return new LoanRequest(contactInformation);
    }

    public SocialSecurityNumber getSocialSecurityNumber() {
        return contactInformation.getSocialSecurityNumber();
    }

}
