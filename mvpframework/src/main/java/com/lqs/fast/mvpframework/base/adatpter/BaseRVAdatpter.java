package com.lqs.fast.mvpframework.base.adatpter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lqs.fast.mvpframework.bean.vo.IListVO;

import java.util.List;

/**
 * Created by dell on 2016/11/23.
 */

public abstract class BaseRVAdatpter<VO extends IListVO> extends RecyclerView.Adapter<AClickRVHolder> {

    private IRVItemClickListener mClickListener;

    private IRVItemLongClickListener mLongClickListener;

    List<VO> mVoList;

    public BaseRVAdatpter(List<VO> voList) {
        this.mVoList = voList;
    }

    @Override
    public int getItemCount() {
        return mVoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        int itemType = mVoList.get(position).getItemType();
        return itemType;
    }

    public interface IRVItemClickListener {
        void onClick(View itemView, int posiction);
    }

    public void setClickListener(IRVItemClickListener clickListener) {
        this.mClickListener = clickListener;
    }

    public interface IRVItemLongClickListener {
        void onLongClick(View itemView, int posiction);
    }

    public void setLongClickListener(IRVItemLongClickListener longClickListener) {
        this.mLongClickListener = longClickListener;
    }
}
