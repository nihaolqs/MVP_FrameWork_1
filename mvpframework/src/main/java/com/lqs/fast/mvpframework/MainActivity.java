package com.lqs.fast.mvpframework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));  //布局管理器
        RecyclerView.Adapter adapter = new MyRecyclerViewAdatpter();
        mRecyclerView.setAdapter(adapter);  //设置适配器
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());  //设置动画
    }


    public class MyRecyclerViewHolder extends RecyclerView.ViewHolder{

        public MyRecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class MyRecyclerViewAdatpter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>{

    }
}
