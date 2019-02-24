package be.tim.codingtim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialSecurityNumberTest {

    @Test
    void validSocialSecurityNumber() {
        SocialSecurityNumber socialSecurityNumber = SocialSecurityNumber.of("123-45-6789");
        assertNotNull(socialSecurityNumber);
        assertEquals("123-45-6789", socialSecurityNumber.getNumber());
    }

    @Test
    void invalidSocialSecurityNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SocialSecurityNumber.of("123-45-678")
        );
    }
}