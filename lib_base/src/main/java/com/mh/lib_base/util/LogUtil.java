package com.mh.lib_base.util;

import android.util.Log;

import com.mh.lib_base.BuildConfig;

/**
 * Log工具类
 */
public class LogUtil {

    private LogUtil() {

    }

    public final static String TAG = "DEFAULT";

    /**
     * 是否需要开启Log
     */
    private final static boolean NEED_LOG = BuildConfig.DEBUG;

    public static void i(String content) {
        if (NEED_LOG) {
            Log.i(TAG, getLogPrefix() + content);
        }
    }

    public static void i(String tag, String content) {
        if (NEED_LOG) {
            Log.i(tag, getLogPrefix() + content);
        }
    }

    public static void d(String content) {
        if (NEED_LOG) {
            Log.d(TAG, getLogPrefix() + content);
        }
    }

    public static void d(String tag, String content) {
        if (NEED_LOG) {
            Log.d(tag, getLogPrefix() + content);
        }
    }

    public static void e(String content) {
        if (NEED_LOG) {
            Log.e(TAG, getLogPrefix() + content);
        }
    }

    public static void e(String tag, String content) {
        if (NEED_LOG) {
            Log.e(tag, getLogPrefix() + content);
        }
    }

    public static void v(String content) {
        if (NEED_LOG) {
            Log.v(TAG, getLogPrefix() + content);
        }
    }

    public static void v(String tag, String content) {
        if (NEED_LOG) {
            Log.v(tag, getLogPrefix() + content);
        }
    }

    public static void w(String content) {
        if (NEED_LOG) {
            Log.w(TAG, getLogPrefix() + content);
        }
    }

    public static void w(String tag, String content) {
        if (NEED_LOG) {
            Log.w(tag, getLogPrefix() + content);
        }
    }

    private static String getLogPrefix() {
        return getClassName() + "(" + getLineNumber() + ")" + "$" + getMethodName() + ": ";
    }

    /**
     * 获取Log所在的类名 （getStackTrace的索引根据调用的顺序来决定，可通过打印Log栈来获取）
     */
    private static String getClassName() {
        try {
            String classPath = Thread.currentThread().getStackTrace()[5].getClassName();
            return classPath.substring(classPath.lastIndexOf(".") + 1);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * 获取Log所在的方法名
     */
    private static String getMethodName() {
        try {
            return Thread.currentThread().getStackTrace()[5].getMethodName();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * 获取Log所在的行
     */
    private static int getLineNumber() {
        try {
            return Thread.currentThread().getStackTrace()[5].getLineNumber();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return 0;
    }
}
