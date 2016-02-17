package com.dgsd.android.callme.parser;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AlwaysValidPhoneNumberParserTest {

    @Test
    public void testReturnsTrueForNullInput() {
        final AlwaysValidPhoneNumberParser parser = new AlwaysValidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber(null);

        assertThat(result).isTrue();
    }

    @Test
    public void testReturnsTrueForEmptyInput() {
        final AlwaysValidPhoneNumberParser parser = new AlwaysValidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("");

        assertThat(result).isTrue();
    }

    @Test
    public void testReturnsTrueForInvalidInput() {
        final AlwaysValidPhoneNumberParser parser = new AlwaysValidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("this is not a phone number");

        assertThat(result).isTrue();
    }

    @Test
    public void testReturnsTrueForValidInput() {
        final AlwaysValidPhoneNumberParser parser = new AlwaysValidPhoneNumberParser();

        final boolean result = parser.isValidPhoneNumber("415 849 1234");

        assertThat(result).isTrue();
    }
}