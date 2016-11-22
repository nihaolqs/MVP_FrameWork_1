package com.lqs.fast.mvpframework.event.message;

import android.content.Intent;

/**
 * Created by dell on 2016/11/22.
 * //启动新Activity 的Event信息类 requestCode不为0;
 */

public class StartActivityEvent {


    private Intent mIntent;
    private int requestCode;

    public StartActivityEvent(Intent intent) {
        this.mIntent = intent;
    }

    public StartActivityEvent(Intent intent, int requestCode) {
        this.mIntent = intent;
        this.requestCode = requestCode;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

}
