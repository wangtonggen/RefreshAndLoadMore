package com.refreshandloadmore.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.refreshandloadmore.R;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler2;
import in.srain.cube.views.ptr.views.PtrExpandableListView;

/**
 * Created by 王统根
 * time 2016/11/17
 * desc 描述
 */

public class ExpandableListViewActivity extends AppCompatActivity {
    PtrClassicFrameLayout rotate_header_list_view_frame;
    PtrExpandableListView rotate_header_list_view;

    private List<String> groupArray;
    private List<List<String>> childArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_header_with_expandable_view);
        rotate_header_list_view_frame = (PtrClassicFrameLayout) findViewById(R.id.fragment_ptr_home_ptr_frame);
        rotate_header_list_view = (PtrExpandableListView) findViewById(R.id.rotate_header_list_view);

        initExpand();
        initRefresh();
    }

    private void initExpand() {
        groupArray = new ArrayList<>();
        childArray = new ArrayList<>();
        groupArray.add("第一行");
        groupArray.add("第二行");

        List<String> tempArray = new ArrayList<>();
        tempArray.add("第一条");
        tempArray.add("第二条");
        tempArray.add("第三条");
        tempArray.add("第四条");
        tempArray.add("第五条");
        tempArray.add("第六条");
        tempArray.add("第七条");

        for (int index = 0; index < groupArray.size(); ++index) {
            childArray.add(tempArray);
        }
        rotate_header_list_view.setAdapter(new ExpandableAdapter(ExpandableListViewActivity.this));
    }

    //ExpandableListView的Adapter
    public class ExpandableAdapter extends BaseExpandableListAdapter {
        Activity activity;

        public ExpandableAdapter(Activity a) {
            activity = a;
        }

        public Object getChild(int groupPosition, int childPosition) {
            return childArray.get(groupPosition).get(childPosition);
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            return childArray.get(groupPosition).size();
        }

        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            String string = childArray.get(groupPosition).get(childPosition);
            return getGenericView(string);
        }

        // group method stub
        public Object getGroup(int groupPosition) {
            return groupArray.get(groupPosition);
        }

        public int getGroupCount() {
            return groupArray.size();
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            String string = groupArray.get(groupPosition);
            return getGenericView(string);
        }

        // View stub to create Group/Children 's View
        public TextView getGenericView(String string) {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 150);
            TextView text = new TextView(activity);
            text.setLayoutParams(layoutParams);
            // Center the text vertically
            text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            text.setPadding(36, 0, 0, 0);
            text.setText(string);
            return text;
        }

        public boolean hasStableIds() {
            return false;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
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
