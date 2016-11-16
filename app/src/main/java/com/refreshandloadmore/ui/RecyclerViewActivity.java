package com.refreshandloadmore.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.refreshandloadmore.R;
import com.refreshandloadmore.Utils.SyLinearLayoutManager;
import com.refreshandloadmore.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;
import in.srain.cube.views.ptr.views.PullableListView;
import in.srain.cube.views.ptr.views.PullableRecyclerView;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class RecyclerViewActivity extends AppCompatActivity{
    PtrClassicFrameLayout rotate_header_list_view_frame;
    PullableRecyclerView rotate_header_list_view;

    private List<String> datas = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_header_with_recycler_view);
        rotate_header_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);
        rotate_header_list_view = (PullableRecyclerView) findViewById(R.id.rotate_header_list_view);

        initRefresh();
        initRecyclerView();
    }

    private void initRefresh(){
        rotate_header_list_view_frame.setLastUpdateTimeRelateObject(this);

        rotate_header_list_view_frame.setPtrHandler(new PtrHandler2() {
            @Override
            public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                return PtrDefaultHandler.checkContentCanBePulledUp(frame, content, footer);
            }

            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                rotate_header_list_view_frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rotate_header_list_view_frame.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                rotate_header_list_view_frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rotate_header_list_view_frame.refreshComplete();
                    }
                }, 2000);
            }
        });
    }

    private void initRecyclerView(){
        for (int i= 0; i < 10;i++){
            datas.add("我是呆小萌"+i);
        }
        adapter = new RecyclerViewAdapter(datas);
//        rotate_header_list_view.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rotate_header_list_view.setLayoutManager(new LinearLayoutManager(this));
        rotate_header_list_view.setAdapter(adapter);
    }
}
