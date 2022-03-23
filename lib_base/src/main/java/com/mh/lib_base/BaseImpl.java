package com.mh.lib_base;

import android.support.annotation.ColorRes;

public interface BaseImpl {
    int getLayoutView();

    boolean isShowTitleBar();

    void bindListener();

    void initData();

    void initLayoutView();

    String getTitleString();

    @ColorRes
    int setTitleViewBarBg();

    @ColorRes
    int setTitleBarBg();
}
