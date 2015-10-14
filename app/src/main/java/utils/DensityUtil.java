package utils;

import android.content.Context;

/**
 * 从设备像素到普通像素的转换
 * Created by Miss on 2015/10/12.
 */
public class DensityUtil {
    /**
     * 根据手机分辨率从 dip 的单位 转成为 px 像素
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px 像素 的单位 转成为 dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
