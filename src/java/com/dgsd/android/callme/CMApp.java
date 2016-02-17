package com.dgsd.android.callme;

import android.app.Application;
import com.dgsd.android.callme.parser.GooglePhoneNumberParser;
import com.dgsd.android.callme.parser.PhoneNumberParser;

import java.util.Locale;

public class CMApp extends Application {

    private PhoneNumberParser mPhoneNumberParser;

    @Override
    public void onCreate() {
        super.onCreate();

        final Locale locale = Locale.getDefault();
        if (locale == null) {
            mPhoneNumberParser = new GooglePhoneNumberParser();
        } else {
            mPhoneNumberParser = new GooglePhoneNumberParser(locale.getCountry());
        }
    }

    public PhoneNumberParser getPhoneNumberParser() {
        return mPhoneNumberParser;
    }
}
