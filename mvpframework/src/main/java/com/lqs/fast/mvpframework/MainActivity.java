package com.lqs.fast.mvpframework;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lqs.fast.mvpframework.base.adatpter.AClickRVHolder;
import com.lqs.fast.mvpframework.base.adatpter.BaseRVAdatpter;
import com.lqs.fast.mvpframework.bean.vo.IListVO;
import com.lqs.fast.mvpframework.utils.ImageUtils;
import com.lqs.fast.mvpframework.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        UiUtils.initUiUtils(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));  //布局管理器
        final MyRecyclerViewAdatpter adapter = new MyRecyclerViewAdatpter();
        adapter.addHeaderView(UiUtils.inflaterLayout(R.layout.recycler_view_header));
        List<VO> volist = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            VO e = new VO();
            e.title = "" + i;
            volist.add(e);
        }
        adapter.addDataList(volist);
        View headerview = UiUtils.inflaterLayout(R.layout.recycler_view_header);
        adapter.addHeaderView(headerview);
        adapter.addDataList(volist);
        adapter.setClickListener(new BaseRVAdatpter.IRVItemClickListener() {
            @Override
            public void onClick(View itemView, int posiction) {
                Toast.makeText(MainActivity.this, "" + (posiction - adapter.getHeaderViewCount(posiction)), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(adapter);  //设置适配器
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());  //设置动画
        adapter.notifyDataSetChanged();
    }

    public class MyRecyclerViewAdatpter extends BaseRVAdatpter<VO> {

        @Override
        protected AClickRVHolder onCreateNoHeaderViewHolder(ViewGroup parent, int viewType) {
            View view = UiUtils.inflaterLayout(R.layout.recycler_view_item);
            VH vh = new VH(view, mClickListener, mLongClickListener);
            vh.mTextView = (TextView) view.findViewById(R.id.textView);
            return vh;
        }

        @Override
        protected void onBindNoHeaderViewHolder(AClickRVHolder holder, int position) {
            ((VH) holder).mTextView.setText(((VO) mVoList.get(position)).title);
        }
    }

    class VO implements IListVO {

        String title;

        @Override
        public int getItemType() {
            return 0;
        }
    }

    class VH extends AClickRVHolder {

        TextView mTextView;

        public VH(View itemView, BaseRVAdatpter.IRVItemClickListener clickListener, BaseRVAdatpter.IRVItemLongClickListener longClickListener) {
            super(itemView, clickListener, longClickListener);
        }
    }
}
