package com.acterics.validationlib;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 02.11.17.
 */

public class ValidatorUnitTest {
    private Validator validator = Validator.getInstance();

    @Test
    public void emailValidationTest() {
        String validEmail1 = "test@email.com";
        String validEmail2 = "test.dot@email.com";
        String validEmail3 = "test-line@email.com";

        String invalidEmail1 = "";
        String invalidEmail2 = "test";
        String invalidEmail3 = "test@";
        String invalidEmail4 = "test@email";
        String invalidEmail5 = "test@email.";
        String invalidEmail6 = "test@email.@";
        String invalidEmail7 = "@test@email.@";
        String invalidEmail8 = "te@st@email.com";
        String invalidEmail9 = "te@st@email.com";

        List<String> invalidEmails = Arrays.asList(
                invalidEmail1, invalidEmail2, invalidEmail3,
                invalidEmail4, invalidEmail5, invalidEmail6,
                invalidEmail7, invalidEmail8, invalidEmail9);
        List<String> validEmails = Arrays.asList(validEmail1, validEmail2, validEmail3);

        for (String valid : validEmails) {
            assertTrue(valid, validator.isValidEmail(valid));
        }
        for (String invalid: invalidEmails) {
            assertFalse(invalid, validator.isValidEmail(invalid));
        }
    }

    @Test
    public void phoneNumberValidationTest() {
        String validPhone1 = "+3 80111111111";
        String validPhone2 = "+380 111111111";
        String validPhone3 = "+380111111111";
        String validPhone4 = "+3 8 0111111111";
        String validPhone5 = "+3 80 11 1111111";
        String validPhone6 = "+380(11) 1111111";

        String invalidPhone1 = "";
        String invalidPhone2 = "1";
        String invalidPhone3 = "3 80111111111";
        String invalidPhone4 = "+3 80111111111q";
        String invalidPhone5 = "+";
        String invalidPhone6 = "++3 80111111111";
        String invalidPhone7 = "+3 801111111 11 ";


        List<String> invalidPhones = Arrays.asList(
                invalidPhone1, invalidPhone2, invalidPhone3,
                invalidPhone4, invalidPhone5, invalidPhone6,
                invalidPhone7);
        List<String> validPhones = Arrays.asList(
                validPhone1, validPhone2, validPhone3,
                validPhone4, validPhone5, validPhone6);

        for (String valid : validPhones) {
            assertTrue(valid, validator.isValidPhoneNumber(valid));
        }
        for (String invalid: invalidPhones) {
            assertFalse(invalid, validator.isValidPhoneNumber(invalid));
        }
    }
}
