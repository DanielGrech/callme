package com.dgsd.android.callme.parser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlwaysInValidPhoneNumberParserTest {

    @Test
    public void testReturnsFalseForNullInput() {
        final AlwaysInvalidPhoneNumberParser parser = new AlwaysInvalidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber(null);

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsFalseForEmptyInput() {
        final AlwaysInvalidPhoneNumberParser parser = new AlwaysInvalidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("");

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsFalseForInvalidInput() {
        final AlwaysInvalidPhoneNumberParser parser = new AlwaysInvalidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("this is not a phone number");

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsFalseForValidInput() {
        final AlwaysInvalidPhoneNumberParser parser = new AlwaysInvalidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("415 849 1234");

        assertThat(result).isFalse();
    }
}