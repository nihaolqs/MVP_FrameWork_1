package com.lqs.fast.mvpframework.base.model;

import com.lqs.fast.mvpframework.base.IClassTAG;
import com.lqs.fast.mvpframework.base.presenter.ABasePresenter;

import java.util.HashMap;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABaseModel implements IClassTAG {
    protected HashMap<String, ABasePresenter> mPresenterMap = new HashMap<>();

    public void addPresenter(ABasePresenter presenter) {
        mPresenterMap.put(presenter.getTAG(), presenter);
    }

    public ABasePresenter getPresenterForTag(String tag) {
        ABasePresenter presenter = mPresenterMap.get(tag);
        if (presenter == null) {
            throw new RuntimeException(tag + "/获取不到Presenter");
        }
        return presenter;
    }
}
