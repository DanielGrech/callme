package com.dgsd.android.callme.activity;

import android.content.Intent;
import com.dgsd.android.callme.R;
import com.dgsd.android.callme.util.IntentUtil;

/**
 * {@link BaseTextActionActivity} subclass which opens the native dialler application
 */
public class TextActionCallActivity extends BaseTextActionActivity {

    @Override
    void handleText(String input) {
        final Intent intent = IntentUtil.getDialIntent(input);
        if (IntentUtil.isAvailable(this, intent)) {
            startActivity(intent);
        } else {
            throw new RuntimeException("No dial intent available");
        }
    }

    @Override
    int getErrorMessageResource() {
        return R.string.error_message_call;
    }
}
