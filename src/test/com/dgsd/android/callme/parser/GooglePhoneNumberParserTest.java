package com.dgsd.android.callme.parser;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GooglePhoneNumberParserTest {

    @Test
    public void testReturnsFalseForNullInput() {
        final GooglePhoneNumberParser parser = new GooglePhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber(null);

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsFalseForEmptyInput() {
        final GooglePhoneNumberParser parser = new GooglePhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("");

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsFalseForInvalidInput() {
        final GooglePhoneNumberParser parser = new GooglePhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("this is not a phone number");

        assertThat(result).isFalse();
    }

    @Test
    public void testReturnsTrueForValidInputWithNoHint() {
        final GooglePhoneNumberParser parser = new GooglePhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("415 849 1234");

        assertThat(result).isTrue();
    }

    @Test
    public void testReturnsTrueForValidInputWithHint() {
        final GooglePhoneNumberParser parser = new GooglePhoneNumberParser("US");

        final boolean result = parser.isValidPhoneNumber("415 849 1234");

        assertThat(result).isTrue();
    }
}