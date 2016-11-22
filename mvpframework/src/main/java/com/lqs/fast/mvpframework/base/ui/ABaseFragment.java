package com.lqs.fast.mvpframework.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lqs.fast.mvpframework.event.SingleEventBus;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class ABaseFragment extends Fragment {
    protected static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    protected LayoutInflater mLayoutInflater;
    private View mFragmentLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mLayoutInflater = inflater;
        if (savedInstanceState == null) {
            mFragmentLayout = mLayoutInflater.inflate(getLayoutResources(), null);
            initUi();
        }
        initData();
        return mFragmentLayout;
    }

    protected abstract void initData();  //初始化数据

    protected abstract void initUi();  //初始化UI

    protected abstract int getLayoutResources();  //返回布局ID

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {   //内存恢复时防止重叠
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SingleEventBus.getInstance().register(this);   //注册事件总线
    }

    @Override
    public void onStop() {
        super.onStop();
        SingleEventBus.getInstance().unregister(this);  //注销事件总线
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());  //保存显示状态
    }

    /**
     * 实例化Fragment的方法
     * @param clzz ABaseFragment 的子类
     * @param bundle Fragment 的附加附加数据
     * @param <T>  实例化子类泛型约束
     * @return
     * @throws IllegalAccessException
     * @throws java.lang.InstantiationException
     */
    public static<T extends ABaseFragment> Fragment getInstance(Class<T> clzz ,Bundle bundle) throws IllegalAccessException, java.lang.InstantiationException {
        T t = clzz.newInstance();
        t.setArguments(bundle);
        return t;
    }
}
