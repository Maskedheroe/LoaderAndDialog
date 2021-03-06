package com.example.fangxy.ui;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

public final class LoaderCreator {

    private static final WeakHashMap<String,Indicator> LOADING_MAP = new WeakHashMap<>();

    static AVLoadingIndicatorView create(String type, Context context){
        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
        if (LOADING_MAP.get(type)==null){
            final Indicator indaicator = getIndaicator(type);
            LOADING_MAP.put(type,indaicator);
        }
        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));//用缓存的方式使用AVLoading
        return avLoadingIndicatorView;
    }

    private static Indicator getIndaicator(String name){
        if (name == null|| name.isEmpty()){
            return null;
        }
        final StringBuilder drawableClassName = new StringBuilder();
        if (!name.contains(".")){
            final String defaulePackageName = AVLoadingIndicatorView.class.getPackage().getName();
            drawableClassName.append(defaulePackageName)
                    .append(".indicators")
                    .append(".");

        }
        drawableClassName.append(name);
        try {
            final Class<?> drawableClass = Class.forName(drawableClassName.toString());
            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
