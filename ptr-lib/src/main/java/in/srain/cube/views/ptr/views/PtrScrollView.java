package in.srain.cube.views.ptr.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import in.srain.cube.views.ptr.interfaes.PullableView;

/**
 * Created by 王统根
 * time 2016/11/15
 * desc 自定义scrollView
 */

public class PtrScrollView extends ScrollView implements PullableView {
    /**
     * 判断是否需要下拉
     */
    private boolean canPullDown = false;
    /**
     * 判断是否需要上拉
     */
    private boolean canPullUp = false;
    public PtrScrollView(Context context) {
        super(context);
    }

    public PtrScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PtrScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean canPullDown() {
        return getScrollY() == 0;
    }

    @Override
    public boolean canPullUp() {
        View childView = getChildAt(0);
        return childView.getMeasuredHeight() <= getScrollY() + getHeight();
    }
}
