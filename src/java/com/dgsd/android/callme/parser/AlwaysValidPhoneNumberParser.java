package com.dgsd.android.callme.parser;

/**
 * A {@link PhoneNumberParser} which always validates input no-matter what the format
 */
public class AlwaysValidPhoneNumberParser implements PhoneNumberParser {

    @Override
    public boolean isValidPhoneNumber(String input) {
        return true;
    }
}
