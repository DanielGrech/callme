package com.dgsd.android.callme.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import android.support.annotation.NonNull;
import android.text.TextUtils;

/**
 * Utilities for opening and inspecting intents
 */
public class IntentUtil {

    private IntentUtil() {
        // No instances..
    }

    /**
     * Check if there is an activity which can handle the given intent
     *
     * @return <code>true</code> if there is an activity which will be opened by starting the given intent,
     * <code>false</code> if doing so will result in an {@link android.content.ActivityNotFoundException}
     */
    public static boolean isAvailable(@NonNull Context context, @NonNull Intent intent) {
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    /**
     * @param number The phone number to dial
     * @return An {@link Intent} which will open the native phone dialler
     */
    public static Intent getDialIntent(@NonNull String number) {
        return new Intent(Intent.ACTION_DIAL)
            .setData(Uri.parse("tel:" + number));
    }

    /**
     * @param context Used to find the default SMS application package
     * @param number  The phone number to send the sms too
     * @return An {@link Intent} which will open the default SMS application
     */
    public static Intent getSmsIntent(@NonNull Context context, @NonNull String number) {
        final String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context);

        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null));

        if (TextUtils.isEmpty(defaultSmsPackage)) {
            return intent;
        } else {
            return intent.setPackage(defaultSmsPackage);
        }
    }
}
