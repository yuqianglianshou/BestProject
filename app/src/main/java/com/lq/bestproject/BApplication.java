package com.lq.bestproject;

import android.app.Application;

/**
 * lq
 */
public class BApplication extends Application {

    private static BApplication app;

    public BApplication() {
        app = this;
    }

    public static synchronized BApplication getInstance() {
        if (app == null) {
            app = new BApplication();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


}