package com.mh.lib_base.base;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public static BaseApplication getApplication() {
        return myApp;
    }
}
