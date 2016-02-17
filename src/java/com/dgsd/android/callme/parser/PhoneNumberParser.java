package com.dgsd.android.callme.parser;

public interface PhoneNumberParser {

    /**
     * Validate if the given input is a valid phone number
     *
     * @param input The prospective phone number
     * @return <code>true</code> if the phone number is considered valid, <code>false</code> otherwise
     */
    boolean isValidPhoneNumber(String input);
}
