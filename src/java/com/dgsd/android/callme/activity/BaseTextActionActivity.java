package com.dgsd.android.callme.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.dgsd.android.callme.BuildConfig;
import com.dgsd.android.callme.CMApp;

/**
 * Base class for all activities which intercept text actions on phone numbers
 */
abstract class BaseTextActionActivity extends Activity {

    /**
     * Responsible for taking action on the intercepted phone number
     *
     * @param phoneNumber The phone number to handle. Assumed to be non-null and in a valid format
     */
    abstract void handleText(String phoneNumber);

    /**
     * @return A string resource for an error message to show if an error should occur
     */
    @StringRes
    abstract int getErrorMessageResource();

    private CMApp mApp;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApp = (CMApp) getApplication();

        handleIntent(getIntent());
    }

    @Override
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    final void handleIntent(@NonNull Intent intent) {
        final CharSequence text = intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);

        try {
            if (!TextUtils.isEmpty(text)) {
                final String input = text.toString();

                if (mApp.getPhoneNumberParser().isValidPhoneNumber(input)) {
                    handleText(input);
                } else {
                    throw new RuntimeException("'" + input + "' is not a valid number");
                }
            } else {
                throw new IllegalArgumentException("Empty text found in Intent");
            }
        } catch (Exception ex) {
            if (BuildConfig.DEBUG) {
                Log.e(getClass().getName(), "Error starting next activity", ex);
            }
            Toast.makeText(this, getErrorMessageResource(), Toast.LENGTH_LONG).show();
        }

        setResult(RESULT_OK);
        finish();
    }
}
