package in.srain.cube.views.ptr.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ExpandableListView;

import in.srain.cube.views.ptr.interfaes.PullableView;

/**
 * Created by 王统根
 * time 2016/11/17
 * desc 描述
 */

public class PtrExpandableListView extends ExpandableListView implements PullableView {
    public PtrExpandableListView(Context context) {
        super(context);
    }

    public PtrExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PtrExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean canPullUp() {
        Log.e("ExpandableListView",(computeVerticalScrollExtent() + computeVerticalScrollOffset())+"--"+computeVerticalScrollRange());
        return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) == computeVerticalScrollRange();
    }

    @Override
    public boolean canPullDown() {
        return false;
    }
}
