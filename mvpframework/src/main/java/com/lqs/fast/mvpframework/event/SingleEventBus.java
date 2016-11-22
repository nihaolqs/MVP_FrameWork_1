package com.lqs.fast.mvpframework.event;

import com.squareup.otto.Bus;

/**
 * Created by dell on 2016/11/22.
 */

public class SingleEventBus extends Bus {
    private SingleEventBus() {

    }

    private static SingleEventBus mEventBus;

    public static SingleEventBus getInstance() {
        if (mEventBus == null) {
            mEventBus = new SingleEventBus();
        }
        return mEventBus;
    }
}
