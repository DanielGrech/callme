package com.dgsd.android.callme.parser;

import android.support.annotation.Nullable;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.Collection;

/**
 * A {@link PhoneNumberParser} which uses the libphonenumber library to validate numbers
 */
public class GooglePhoneNumberParser implements PhoneNumberParser {

    private final PhoneNumberUtil mPhoneNumberUtil;

    /**
     * An immutable set of region codes which the Google library is capable of parsing
     */
    private final Collection<String> mValidRegions;

    /**
     * An optional region code (E.g. "AU") to hint to the parser the expected format of given input numbers
     */
    @Nullable
    private final String mRegionHint;

    public GooglePhoneNumberParser() {
        this(null);
    }

    /**
     * @param regionHint An optional region code (E.g. "AU") to hint to the parser the expected format of given
     *                   input numbers
     */
    public GooglePhoneNumberParser(@Nullable String regionHint) {
        mPhoneNumberUtil = PhoneNumberUtil.getInstance();
        mValidRegions = mPhoneNumberUtil.getSupportedRegions();

        if (regionHint != null && mValidRegions.contains(regionHint)) {
            mRegionHint = regionHint;
        } else {
            mRegionHint = null;
        }
    }

    @Override
    public boolean isValidPhoneNumber(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // If we have a hint for the region we'd like to check, use it...
        if (mRegionHint != null && mPhoneNumberUtil.isPossibleNumber(input, mRegionHint)) {
            return true;
        }

        // ... otherwise, just check all regions
        for (String regionCode : mValidRegions) {
            if (mPhoneNumberUtil.isPossibleNumber(input, regionCode)) {
                return true;
            }
        }

        return false;
    }
}
