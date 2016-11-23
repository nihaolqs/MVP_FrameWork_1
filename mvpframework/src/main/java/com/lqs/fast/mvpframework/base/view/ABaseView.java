package com.lqs.fast.mvpframework.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lqs.fast.mvpframework.base.IClassTAG;
import com.lqs.fast.mvpframework.base.presenter.ABasePresenter;
import com.lqs.fast.mvpframework.base.ui.ABaseFragment;

import java.util.HashMap;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABaseView extends ABaseFragment implements IClassTAG {

    protected HashMap<String, ABasePresenter> mPresenterMap = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onCreate();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onCreateView();
        }

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onActivityCreated();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onDestroy();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (ABasePresenter presenter : mPresenterMap.values()) {
            presenter.onActivityResult(requestCode, resultCode, data);
        }
    }

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
