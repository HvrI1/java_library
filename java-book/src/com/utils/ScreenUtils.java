package com.utils;

import javax.naming.Context;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ScreenUtils {

    //屏幕宽度
    private static int mScreenW;
    //屏幕高度
    private static int mScreenH;
    //密度
    private static float mDensity;

    /**
     * 使用前必须初始化一下
     *
     * @param activity
     */



    /**
     * 获取屏幕宽度
     *
     * @return
     */

    public static int  getScreenW() {
        return mScreenW;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */

    public static int getScreenH() {
        return mScreenH;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dpValue
     * @return
     */

    public static int dip2px(float dpValue) {
        return (int) (dpValue * mDensity + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue
     * @return
     */

    public static int px2dip(float pxValue) {
        return (int) (pxValue / mDensity + 0.5f);
    }

    /**
     * 根据720px的屏幕进行转化
     *
     * @param pxValue
     * @return
     */

    public static int px720dip(float pxValue) {
        int result = (int) (pxValue * mScreenW / 720);
        return result;
    }

    /**
     * 根据1080px的屏幕进行转化
     *
     * @param pxValue
     * @return
     */

    public static int px1080dip(float pxValue) {
        int result = (int) (pxValue * mScreenW / 1080);
        return result;
    }

    /**
     * 获取顶部标题栏的高度
     *
     * @param context
     * @return
     */




}
