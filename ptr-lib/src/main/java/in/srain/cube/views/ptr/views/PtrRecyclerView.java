package in.srain.cube.views.ptr.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import in.srain.cube.views.ptr.interfaes.PullableView;
import in.srain.cube.views.ptr.util.WindowManagerUtils;

/**
 * Created by 王统根
 * time 2016/11/15
 * desc 自定义RecycleRecyclerView
 */

public class PtrRecyclerView extends RecyclerView implements PullableView {
    private Context context;
    public PtrRecyclerView(Context context) {
        super(context);
        this.context = context;
    }

    public PtrRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public PtrRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    @Override
    public boolean canPullUp() {
//        if (WindowManagerUtils.getWindowHeight(context) > computeVerticalScrollRange()){//没有满屏
//            return false;
//        }else {//满屏并且滑动到底部才返回true
//            return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) >= computeVerticalScrollRange();
//        }

        Log.e("recycler",(computeVerticalScrollExtent() + computeVerticalScrollOffset())+"--"+computeVerticalScrollRange());
        return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) == computeVerticalScrollRange();
    }

    //TODO 问题带解决 recyclerView高度是有manager来控制的,
    // 然后通过获取manager的高度然后对比屏幕的高度来达到是否到达底部
    @Override
    public boolean canPullDown() {
        return false;
    }
}
