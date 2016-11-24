package com.lqs.fast.mvpframework.base.adatpter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.lqs.fast.mvpframework.R;
import com.lqs.fast.mvpframework.bean.vo.IListVO;
import com.lqs.fast.mvpframework.utils.ImageUtils;
import com.lqs.fast.mvpframework.utils.UiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 2016/11/23.
 */

public abstract class BaseRVAdatpter<VO extends IListVO> extends RecyclerView.Adapter<AClickRVHolder> {

    private static final int HEADER_VIEW_TYPE = 0xFFFFFF;

    protected IRVItemClickListener mClickListener;

    protected IRVItemLongClickListener mLongClickListener;

    protected List<IListVO> mVoList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return mVoList.size();
    }

    @Override
    public AClickRVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            View headerViewRoot = UiUtils.inflaterLayout(R.layout.recycler_view_root);
            return new HeaderViewHolder(headerViewRoot);
        } else {
            return onCreateNoHeaderViewHolder(parent, viewType);
        }
    }

    protected abstract AClickRVHolder onCreateNoHeaderViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(AClickRVHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == HEADER_VIEW_TYPE) {
            View mHeaderView = ((HeaderVO) mVoList.get(position)).getmHeaderView();
            ((HeaderViewHolder) holder).setmHeaderView(mHeaderView);
        } else {
            onBindNoHeaderViewHolder(holder, position);
        }
    }

    protected abstract void onBindNoHeaderViewHolder(AClickRVHolder holder, int position);

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

    public void addHeaderView(View headerview) {
        HeaderVO e = new HeaderVO();
        e.setmHeaderView(headerview);
        this.mVoList.add(e);
    }

    public void addDataList(List<VO> voList) {
        this.mVoList.addAll(voList);
    }

    public int getHeaderViewCount(int posiction) {
        int count = 0;
        for (int i = 0; i < (posiction <= mVoList.size() ? posiction : mVoList.size()); i++) {
            if (getItemViewType(i) == HEADER_VIEW_TYPE) {
                count++;
            }
        }
        return count;
    }

    class HeaderVO implements IListVO {

        private View mHeaderView;

        public View getmHeaderView() {
            return mHeaderView;
        }

        public void setmHeaderView(View mHeaderView) {
            this.mHeaderView = mHeaderView;
        }

        @Override
        public int getItemType() {
            return HEADER_VIEW_TYPE;
        }
    }

    class HeaderViewHolder extends AClickRVHolder {

        public void setmHeaderView(View mHeaderView) {

            ViewGroup parent = (ViewGroup) mHeaderView.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            ViewGroup viewGroup = (ViewGroup) this.itemView;
            viewGroup.removeAllViews();
            viewGroup.addView(mHeaderView);
        }

        public HeaderViewHolder(View itemView) {
            super(itemView, null, null);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = (GridLayoutManager) layoutManager;
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == HEADER_VIEW_TYPE
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    @Override
    public void onViewAttachedToWindow(AClickRVHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams sglmlp = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            int position = holder.getLayoutPosition();
            sglmlp.setFullSpan(getItemViewType(position) == HEADER_VIEW_TYPE);
        }
    }
}
