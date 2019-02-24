package be.tim.codingtim.loan;

import be.tim.codingtim.ContactInformation;
import be.tim.codingtim.SocialSecurityNumber;

public class LoanRequest {
    private ContactInformation contactInformation;

    public LoanRequest(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public SocialSecurityNumber getSocialSecurityNumber() {
        return contactInformation.getSocialSecurityNumber();
    }
}
