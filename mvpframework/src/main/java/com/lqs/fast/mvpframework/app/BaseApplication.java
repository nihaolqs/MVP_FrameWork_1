package com.lqs.fast.mvpframework.app;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lqs.fast.mvpframework.event.SingleHandler;

/**
 * Created by dell on 2016/11/22.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SingleHandler.initHandler(this);

    }
}
