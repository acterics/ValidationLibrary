package com.acterics.validationlib;

import java.util.regex.Pattern;

/**
 * Created by root on 02.11.17.
 */

public class Validator {

    private static Validator instance = null;
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final String PHONE_NUMBER_PATTERN = "^\\+(?:[0-9()] ?){6,14}[0-9]$";
//    private final String PHONE_NUMBER_PATTERN = "/([0-9\\s\\-]{7,})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$/";
//    private final String PHONE_NUMBER_PATTERN = "^\\+(9[976]\\d|8[987530]\\d|6[987]\\d|5[90]\\d|42\\d|3[875]\\d|\n" +
//        "2[98654321]\\d|9[8543210]|8[6421]|6[6543210]|5[87654321]|\n" +
//        "4[987654310]|3[9643210]|2[70]|7|1)\n" +
//        "\\W*\\d\\W*\\d\\W*\\d\\W*\\d\\W*\\d\\W*\\d\\W*\\d\\W*\\d\\W*(\\d{1,2})$";

    private final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    private final Pattern phoneNumberPattern = Pattern.compile(PHONE_NUMBER_PATTERN);


    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    private Validator() {

    }


    public boolean isValidEmail(String email) {
        return emailPattern.matcher(email).matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumberPattern.matcher(phoneNumber).matches();
    }

}
