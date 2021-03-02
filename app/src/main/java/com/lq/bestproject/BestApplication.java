package com.lq.bestproject;

import android.app.Application;

/**
 * lq
 */
public class BestApplication extends Application {

    private static BestApplication app;

    public BestApplication() {
        app = this;
    }

    public static synchronized BestApplication getInstance() {
        if (app == null) {
            app = new BestApplication();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


}