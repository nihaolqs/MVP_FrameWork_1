package com.lqs.fast.mvpframework.base.adatpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.lqs.fast.mvpframework.bean.vo.IListVO;
import com.lqs.fast.mvpframework.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/11/22.
 */

public abstract class MySimpleAdatpter<VO extends IListVO> extends BaseAdapter{

    private List<VO> mVoList;

    public MySimpleAdatpter(Context context, List<VO> voList){
        this.mVoList = voList;
    }
    @Override
    public int getCount() {
        return mVoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemlayout = getItemlayout();

        return itemlayout;
    }

    protected abstract View getItemlayout();
}
