package be.tim.codingtim;

public interface CreditRater {
    //TODO move to other package
    CreditRating rate(SocialSecurityNumber socialSecurityNumber);
}
