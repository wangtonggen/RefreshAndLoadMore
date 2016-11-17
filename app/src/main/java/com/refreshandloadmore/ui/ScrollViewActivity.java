package com.refreshandloadmore.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.refreshandloadmore.R;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class ScrollViewActivity extends AppCompatActivity{

    PtrClassicFrameLayout rotate_header_list_view_frame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_header_with_scroll_view);
        rotate_header_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);

        initRefresh();
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
}
