package in.srain.cube.views.ptr.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.GridView;

import in.srain.cube.views.ptr.interfaes.PullableView;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;
import in.srain.cube.views.ptr.util.WindowManagerUtils;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 自定义gridView
 */

public class PtrGridView extends GridView implements PullableView {
    private Context context;
    private boolean canPullUp = false;
    private boolean canPullDown = false;
    public PtrGridView(Context context) {
        super(context);
        this.context = context;
    }

    public PtrGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public PtrGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    public boolean canPullDown() {

        return canPullDown;
    }

    @Override
    public boolean canPullUp() {
        return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) == computeVerticalScrollRange();
    }
}
