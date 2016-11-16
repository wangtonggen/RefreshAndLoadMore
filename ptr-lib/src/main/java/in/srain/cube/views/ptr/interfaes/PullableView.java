package in.srain.cube.views.ptr.interfaes;

/**
 * Created by 王统根
 * time 2016/11/15
 * desc 描述
 */

public interface PullableView {
    /**
     * 是否可以下拉
     * @return
     */
    boolean canPullDown();

    /**
     * 是否可以上拉
     * @return
     */
    boolean canPullUp();
}
