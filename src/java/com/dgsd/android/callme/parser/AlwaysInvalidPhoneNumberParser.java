package com.dgsd.android.callme.parser;

/**
 * A {@link PhoneNumberParser} which always invalidates input no-matter what the format
 */
public class AlwaysInvalidPhoneNumberParser implements PhoneNumberParser {

    @Override
    public boolean isValidPhoneNumber(String input) {
        return false;
    }
}
