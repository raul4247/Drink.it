package com.raulfm.drinkit.util;

import android.graphics.Color;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

import com.raulfm.drinkit.constants.ColorConstant;

public final class StatusBar {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void SetColor(Window window) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(ColorConstant.PRIMARY_DARK_COLOR));
    }
}
