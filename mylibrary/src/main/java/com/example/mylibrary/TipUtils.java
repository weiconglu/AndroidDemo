package com.example.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class TipUtils {

    public static void shortTips(Context context, String tips) {
        Toast.makeText(context, tips, Toast.LENGTH_SHORT).show();
    }

    public static void longTips(Context context, String tips) {
        Toast.makeText(context, tips, Toast.LENGTH_LONG).show();
    }

}
