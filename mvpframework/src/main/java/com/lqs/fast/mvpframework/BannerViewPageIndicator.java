package com.lqs.fast.mvpframework;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AlphabetIndexer;

import java.util.List;

/**
 * Created by dell on 2016/12/12.
 */

public class BannerViewPageIndicator extends View {

    private static final int DEFAULTINT = -1;
    private int mHeight;
    private int mWidth;
    private ViewPager mViewPage;
    private int mPageCount = DEFAULTINT;   //初始值设置为负数一遍区分是否设置了真实页数
    private int mCurrentItem;
    private List mDataList;

    public BannerViewPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BannerViewPageIndicator(Context context) {
        super(context);
        init();
    }

    private void init() {
        initParame();
        initPaint();
    }

    private void initParame() {
        mHeight = getHeight();
        mWidth = getWidth();
    }

    private void initPaint() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initViewPage();
        canvas.save();
        canvas.translate(mWidth / 2, mHeight / 2);
        for(int i = 0; i < mPageCount; i ++ ){
//            canvas.drawCircle();
        }
    }

    private void initViewPage() {
        if (mDataList != null) {
            mPageCount = mDataList.size();   ///获取ViewPage页数
            mCurrentItem = mViewPage.getCurrentItem() % mPageCount;   //获取当前页码
        } else {
            mPageCount = mViewPage.getAdapter().getCount();
            mCurrentItem = mViewPage.getCurrentItem();
        }
    }

    public void setViewPage(ViewPager viewPage) {
        this.mViewPage = viewPage;
    }

    public void setViewPage(ViewPager viewPage, List bannerData) {
        setViewPage(viewPage);
        mDataList = bannerData;
        this.mPageCount = mDataList.size();
    }

}
