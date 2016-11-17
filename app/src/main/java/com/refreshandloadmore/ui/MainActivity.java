package com.refreshandloadmore.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.refreshandloadmore.R;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;
import in.srain.cube.views.ptr.views.PtrListView;

public class MainActivity extends AppCompatActivity {

    PtrClassicFrameLayout rotate_header_list_view_frame;
    PtrListView rotate_header_list_view;

    private String[] items={"1、ScrollView","2、RecyclerView","3、GridView","4、ExpandableListView"};
//    private String[] items={"1、ArrayAdapter_List","2、SimpleAdapter_List"
//            ,"3、SimpleCursorAdapter_List","4、MyAdapter_List","hahah","enennene"
//            ,"ajhhsuashausha","王大锤","王晓吹","111","222","333","444","555"
//    ,"666","777"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_classic_header_with_list_view);
        Toast.makeText(MainActivity.this,"当前界面使用的是listView",Toast.LENGTH_SHORT).show();
        rotate_header_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);
        rotate_header_list_view = (PtrListView) findViewById(R.id.rotate_header_list_view);

        initListView();

        initRefresh();

        rotate_header_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent scrollViewIntent = new Intent(MainActivity.this,ScrollViewActivity.class);
                        startActivity(scrollViewIntent);
                        break;
                    case 1:
                        Intent recyclerViewIntent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                        startActivity(recyclerViewIntent);
                        break;
                    case 2:
                        Intent gridViewIntent = new Intent(MainActivity.this,GridViewActivity.class);
                        startActivity(gridViewIntent);
                        break;
                    case 3:
                        Intent expandIntent = new Intent(MainActivity.this,ExpandableListViewActivity.class);
                        startActivity(expandIntent);
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"敬请期待",Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

    private void initListView(){
        rotate_header_list_view.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items));
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
