package com.lqs.fast.mvpframework.utils;


import com.lqs.fast.mvpframework.base.model.ABaseModel;
import com.lqs.fast.mvpframework.base.presenter.ABasePresenter;
import com.lqs.fast.mvpframework.base.view.ABaseView;

/**
 * Created by dell on 2016/10/14.
 */

public final class MvpUtils {
    private MvpUtils(){};
    public static<M extends ABaseModel,P extends ABasePresenter, V extends ABaseView> void initMVP(M m, P p, V v){
        m.addPresenter(p);
        p.addModel(m);
        p.addView(v);
        v.addPresenter(p);
    }
    public static<M extends ABaseModel,P extends ABasePresenter, V extends ABaseView> void initMVP( P p, V v){

        p.addView(v);
        v.addPresenter(p);
    }
}
