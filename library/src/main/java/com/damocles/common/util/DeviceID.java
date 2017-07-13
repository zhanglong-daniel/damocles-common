/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.util;

import java.util.UUID;

import com.damocles.common.log.Log;
import com.damocles.common.security.MD5Util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by zhanglong02 on 16/9/13.
 */
public final class DeviceID {

    public static String getID(Context context) {
        // IMEI
        String deviceID = getIMEI(context);
        if (deviceID != null && deviceID.length() == 15) {
            return generateID(deviceID);
        }
        // MAC Address
        deviceID = getMacAddress(context).replaceAll(":", "");
        if (deviceID != null && deviceID.length() > 0) {
            return generateID(deviceID);
        }
        // ANDROID_ID
        deviceID = getAndroidId(context);
        if (deviceID != null && deviceID.length() == 16) {
            return generateID(deviceID);
        }
        deviceID = UUID.randomUUID().toString().replaceAll("-", "");
        return generateID(deviceID);
    }

    private static String generateID(String id) {
        String deviceID;
        try {
            deviceID = MD5Util.md5(id.getBytes());
        } catch (Exception e) {
            Log.printStackTrace(e);
            deviceID = "";
        }
        return deviceID.toUpperCase();
    }

    /**
     * Returns the unique device ID, for example, the IMEI for GSM and the MEID
     * or ESN for CDMA phones. Return null if device ID is not available.
     * <p>
     * <p>Requires Permission:
     * {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
     */
    private static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager == null ? null : telephonyManager.getDeviceId();
    }

    /**
     * A 64-bit number (as a hex string) that is randomly
     * generated when the user first sets up the device and should remain
     * constant for the lifetime of the user's device. The value may
     * change if a factory reset is performed on the device.
     * <p class="note"><strong>Note:</strong> When a device has <a
     * href="{@docRoot}about/versions/android-4.2.html#MultipleUsers">multiple users</a>
     * (available on certain devices running Android 4.2 or higher), each user appears as a
     * completely separate device, so the {@code ANDROID_ID} value is unique to each
     * user.</p>
     */
    private static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    private static String getMacAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return wifiManager == null ? null : wifiManager.getConnectionInfo().getMacAddress();
    }
}
