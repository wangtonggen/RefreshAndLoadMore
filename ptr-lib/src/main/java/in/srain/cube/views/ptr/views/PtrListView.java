package in.srain.cube.views.ptr.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import in.srain.cube.views.ptr.interfaes.PullableView;
import in.srain.cube.views.ptr.util.WindowManagerUtils;

/**
 * Created by 王统根
 * time 2016/11/15
 * desc 自定义ListView 来监听是否需要加载更多
 */

public class PtrListView extends ListView implements PullableView {
    private Context context;
    private boolean canPullDown = false;
    private boolean canPullUp = false;
    public PtrListView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PtrListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public PtrListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init(){
        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case OnScrollListener.SCROLL_STATE_FLING:
                        break;
                    case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        break;
                    case OnScrollListener.SCROLL_STATE_IDLE:

                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem == 0){//顶部
                    canPullUp = false;
                    canPullDown = true;
                }

                if (visibleItemCount >= totalItemCount){//没有满屏
                    canPullUp = false;
                    canPullDown = true;
                }else {
                    if (view.getLastVisiblePosition() == view.getCount() -1){
                        canPullUp = true;
                        canPullDown = false;
                    }else {
                        canPullUp = false;
                        canPullDown = false;
                    }
                }

            }
        });
    }
    @Override
    public boolean canPullUp() {
//        return canPullUp;
//        if (WindowManagerUtils.getWindowHeight(context) > computeVerticalScrollRange()){//没有满屏
//            return false;
//        }else {//满屏并且滑动到底部才返回true
//            return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) >= computeVerticalScrollRange();
//        }

//        Log.e("enen",(computeVerticalScrollExtent() + computeVerticalScrollOffset())+"--"+computeVerticalScrollRange());
//        return (computeVerticalScrollExtent() + computeVerticalScrollOffset()) == computeVerticalScrollRange();

        return canPullUp;
    }

    @Override
    public boolean canPullDown() {
        return canPullDown;
    }
}
