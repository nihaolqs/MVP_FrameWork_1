package com.lqs.fast.mvpframework.base.adatpter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by dell on 2016/11/23.
 */

public abstract class AClickRVHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    private BaseRVAdatpter.IRVItemClickListener mClickListener;

    private BaseRVAdatpter.IRVItemLongClickListener mLongClickListener;

    public AClickRVHolder(View itemView,
                          BaseRVAdatpter.IRVItemClickListener clickListener,
                          BaseRVAdatpter.IRVItemLongClickListener longClickListener) {
        super(itemView);
        if (clickListener != null) {
            mClickListener = clickListener;
            this.itemView.setOnClickListener(this);
        }
        if (longClickListener != null) {
            mLongClickListener = longClickListener;
            this.itemView.setOnLongClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        mClickListener.onClick(this.itemView, getLayoutPosition());
    }

    @Override
    public boolean onLongClick(View v) {
        mLongClickListener.onLongClick(this.itemView, getLayoutPosition());
        return false;
    }
}
