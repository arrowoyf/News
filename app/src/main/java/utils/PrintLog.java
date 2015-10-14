package utils;

import android.util.Log;

/**
 * 打印日志的封装类
 * Created by Miss on 2015/10/14.
 */
public class PrintLog {


    private static boolean isFlag;

    public static void showLog(String str) {

        if (isFlag) {

            Log.d("--->", str);

        } else {

        }
    }
}
