package com.example.fangxy.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;

 
public class DimenUtil {


    private static final Resources resource = null;

    public static int getScreenWidth(){
        final Resources resources = resource;
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHegiht(){
        final Resources resources = resource;
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
