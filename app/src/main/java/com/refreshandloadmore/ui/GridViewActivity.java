package com.refreshandloadmore.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;

import com.refreshandloadmore.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;
import in.srain.cube.views.ptr.views.PtrGridView;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class GridViewActivity extends AppCompatActivity{

    PtrClassicFrameLayout rotate_header_list_view_frame;
    PtrGridView rotate_header_list_view;
    private String[] items={"1、ArrayAdapter_List","2、SimpleAdapter_List"
            ,"3、SimpleCursorAdapter_List","4、MyAdapter_List","hahah","enennene"
            ,"ajhhsuashausha","王大锤","王晓吹","111","222","333","444","555"
    ,"666","777"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_header_with_grid_view);
        rotate_header_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);
        rotate_header_list_view = (PtrGridView) findViewById(R.id.rotate_header_list_view);

        initRefresh();
        initGridView();
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

    private void initGridView(){
//        rotate_header_list_view.setAdapter(new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, items));
        List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
        for (int i = 0; i < 17; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", R.mipmap.ic_launcher);//添加图像资源的ID
            item.put("textItem", "icon" + i);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.gridview_item,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});
        rotate_header_list_view.setAdapter(adapter);
    }
}
