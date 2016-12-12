package com.lqs.fast.mvpframework.event;

import android.content.Context;
import android.os.Handler;

/**
 * Created by dell on 2016/11/22.
 */

public class SingleHandler extends Handler {
    private static SingleHandler sHandlerl;

    private SingleHandler(Context context) {
        super(context.getMainLooper());
    }

    public static void initHandler(Context context) {
        if (sHandlerl == null) {
            sHandlerl = new SingleHandler(context);
        }
    }

    public static Handler getInstance() throws RuntimeException {
        if(sHandlerl == null){
            throw new RuntimeException("SingleHandler没有初始化!");
        }
        return sHandlerl;
    }
}
