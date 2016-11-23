package com.lqs.fast.mvpframework.base.presenter;

import android.content.Intent;


import com.lqs.fast.mvpframework.base.IClassTAG;
import com.lqs.fast.mvpframework.base.model.ABaseModel;
import com.lqs.fast.mvpframework.base.view.ABaseView;
import com.squareup.otto.Bus;

import java.util.HashMap;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABasePresenter implements IClassTAG{

    protected HashMap<String,ABaseView> mViewMap = new HashMap<>();   //存储View的容器
    protected HashMap<String,ABaseModel> mModelMap = new HashMap<>();  //存储Model的容器

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

    public void addView(ABaseView view){
        mViewMap.put(view.getTAG(),view);
    }

    public ABaseView getViewForTag(String tag){
        ABaseView aBaseView = mViewMap.get(tag);
        if(aBaseView == null){
            throw new RuntimeException(tag + "/未能获取View对象");
        }
        return aBaseView;
    }
    public void addModel(ABaseModel model){
        mModelMap.put(model.getTAG(),model);
    }

    public ABaseModel getModelForTag(String tag){
        ABaseModel model = mModelMap.get(tag);
        if(model == null){
            throw new RuntimeException(tag + "/未能获取model对象");
        }
        return model;
    }

}
