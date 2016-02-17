package com.dgsd.android.callme.activity;

import android.content.Intent;
import com.dgsd.android.callme.R;
import com.dgsd.android.callme.util.IntentUtil;

/**
 * {@link BaseTextActionActivity} subclass which opens the native SMS messenger application
 */
public class TextActionSmsActivity extends BaseTextActionActivity {

    @Override
    void handleText(String input) {
        final Intent intent = IntentUtil.getSmsIntent(this, input);
        if (IntentUtil.isAvailable(this, intent)) {
            startActivity(intent);
        } else {
            throw new RuntimeException("No SMS intent available");
        }
    }

    @Override
    int getErrorMessageResource() {
        return R.string.error_message_sms;
    }
}
