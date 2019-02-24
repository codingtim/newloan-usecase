package be.tim.codingtim;

public class SocialSecurityNumber {

    private static final String VALID_REGEX = "[0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9]";

    private String number;

    private SocialSecurityNumber(String number) {
        this.number = number;
    }

    public static SocialSecurityNumber of(String number) {
        if (number.matches(VALID_REGEX)) {
            return new SocialSecurityNumber(number);
        } else {
            throw new IllegalArgumentException("Invalid social security number: " + number);
        }
    }

    public String getNumber() {
        return number;
    }
}
