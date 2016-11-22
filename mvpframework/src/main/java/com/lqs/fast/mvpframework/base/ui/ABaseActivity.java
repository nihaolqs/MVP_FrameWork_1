package com.lqs.fast.mvpframework.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.lqs.fast.mvpframework.event.SingleEventBus;
import com.lqs.fast.mvpframework.event.message.StartActivityEvent;
import com.squareup.otto.Subscribe;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(final Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutResources());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                initUi(savedInstanceState);
                initData();
            }
        });
    }

    protected abstract void initData();

    protected abstract void initUi(Bundle savedInstanceState);

    protected abstract int getLayoutResources();

    @Override
    protected void onResume() {
        super.onResume();
        SingleEventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SingleEventBus.getInstance().unregister(this);
    }

    @Subscribe
    protected void startAct(StartActivityEvent startActivityEvent) {
        int requestCode = startActivityEvent.getRequestCode();
        Intent intent = startActivityEvent.getIntent();
        if (requestCode == 0) {
            startActivity(intent);
        } else {
            startActivityForResult(intent, requestCode);
        }
    }
}
