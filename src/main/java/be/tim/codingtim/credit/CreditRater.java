package be.tim.codingtim.credit;

import be.tim.codingtim.SocialSecurityNumber;

public interface CreditRater {
    CreditRating rate(SocialSecurityNumber socialSecurityNumber);
}
