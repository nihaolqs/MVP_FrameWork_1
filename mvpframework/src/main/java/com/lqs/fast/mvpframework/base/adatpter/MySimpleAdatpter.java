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

public abstract class MySimpleAdatpter<VO extends IListVO> extends BaseAdapter {

    private List<VO> mVoList;

    public MySimpleAdatpter(Context context, List<VO> voList) {
        this.mVoList = voList;
    }

    @Override
    public int getCount() {
        return mVoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        VO vo = mVoList.get(position);
        if (convertView == null) {
            convertView = getItemlayout(vo.getItemType());
            Object viewHolder = getViewHolder(vo.getItemType());
            convertView.setTag(viewHolder);
        }
        Object tag = convertView.getTag();
        initItemView(convertView,tag,vo);
        return convertView;
    }

    protected abstract void initItemView(View convertView, Object tag, VO vo);

    protected abstract Object getViewHolder(int itemType);

    protected abstract View getItemlayout(int itemType);
}
