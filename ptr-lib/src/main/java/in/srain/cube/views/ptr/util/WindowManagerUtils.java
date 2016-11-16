package in.srain.cube.views.ptr.util;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by 王统根
 * time 2016/11/16
 * desc 描述
 */

public class WindowManagerUtils {
    public static int getWindowHeight(Context context){
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
