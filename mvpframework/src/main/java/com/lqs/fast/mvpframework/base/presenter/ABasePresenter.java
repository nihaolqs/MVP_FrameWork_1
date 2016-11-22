package com.lqs.fast.mvpframework.base.presenter;

import android.content.Intent;


import com.lqs.fast.mvpframework.base.model.ABaseModel;
import com.lqs.fast.mvpframework.base.view.ABaseView;
import com.squareup.otto.Bus;

import java.util.HashMap;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABasePresenter {

    private Bus mEvenBus  = new Bus();
    private HashMap<String,ABaseView> mViewMap = new HashMap<>();   //存储View的容器
    private HashMap<String,ABaseModel> mModelMap = new HashMap<>();  //存储Model的容器

    public void onCreate() {
    }

    public void onCreateView() {
    }

    public void onActivityCreated() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroyView() {
    }

    public void onDestroy() {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
