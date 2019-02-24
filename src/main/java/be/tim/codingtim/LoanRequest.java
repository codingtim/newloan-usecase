package be.tim.codingtim;

public class LoanRequest {
    private ContactInformation contactInformation;

    public LoanRequest(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public SocialSecurityNumber getSocialSecurityNumber() {
        return contactInformation.getSocialSecurityNumber();
    }
}
