package be.tim.codingtim;

import java.time.Clock;

public class ContactInformation {

    private SocialSecurityNumber socialSecurityNumber;
    private DateOfBirth dateOfBirth;

    public ContactInformation(SocialSecurityNumber socialSecurityNumber, DateOfBirth dateOfBirth) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public SocialSecurityNumber getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getAge(Clock clock) {
        return dateOfBirth.getAge(clock);
    }
}
