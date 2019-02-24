package be.tim.codingtim.credit;

import be.tim.codingtim.SocialSecurityNumber;

public interface CreditRater {
    //TODO move to other package
    CreditRating rate(SocialSecurityNumber socialSecurityNumber);
}
