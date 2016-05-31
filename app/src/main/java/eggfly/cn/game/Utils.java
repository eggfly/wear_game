package eggfly.cn.game;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by eggfly on 16-5-31.
 */
public class Utils {
    public static int dp2px(Context context, float dp) {
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * displayMetrics.density);
        return px;
    }
}
