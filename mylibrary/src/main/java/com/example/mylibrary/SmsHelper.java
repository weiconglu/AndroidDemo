package com.example.mylibrary;

import android.telephony.SmsManager;

public class SmsHelper {

    /**
     * 发送文本短信
     * @param destinationAddress
     * @param text
     */
    public static void sendTextMessage(String destinationAddress, String text) {
        SmsManager.getDefault().sendTextMessage(destinationAddress, null, text, null, null);
    }

}
