package com.mh.lib_base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.gyf.immersionbar.ImmersionBar;
import com.mh.lib_base.BaseImpl;
import com.mh.lib_base.R;
import com.mh.lib_base.util.SingleClickListener;
import com.mh.lib_base.view.TitleBarView;

abstract public class BaseActivity extends AppCompatActivity implements BaseImpl {
    private TitleBarView mTitleBarView;
    private boolean isFirst = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ImmersionBar.with(this)
                .barAlpha(0.0f)
                .transparentStatusBar()  //透明状态栏，不写默认透明色
                .init();
        if (isShowTitleBar()) {
            mTitleBarView = new TitleBarView(BaseApplication.getApplication());
            mTitleBarView.setTitleViewBarBg(setTitleViewBarBg());
            mTitleBarView.setTitleBarBg(setTitleBarBg());
            mTitleBarView.setOnTitle(getTitleString());
            getRootView().addView(mTitleBarView, 0);
        }
        initLayoutView();
        bindListener();
    }

    /**
     * 获取根视图，就是我们自己设置的视图的父容器，例如这里就是titlebar的容器
     */
    private ViewGroup getRootView() {
        return (ViewGroup) getAndroidContentView().getParent();
    }

    /**
     * 获取android content view
     */
    private View getAndroidContentView() {
        return findViewById(android.R.id.content);
    }

    /**
     * 获取底层的容器
     */
    private FrameLayout getContentView() {
        return (FrameLayout) getAndroidContentView();
    }

    /**
     * 展示标题栏
     *
     * @return true：添加标题栏，否则不添加
     */
    @Override
    public boolean isShowTitleBar() {
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && isFirst) {
            getRootView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    initData();
                }
            }, 500);
        }
        isFirst = false;
    }

    @Override
    public void bindListener() {
        mTitleBarView.setOnBackFinish(new SingleClickListener(new SingleClickListener.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        }));
    }

    @Override
    public int setTitleViewBarBg() {
        return R.color.color_128EE8;
    }

    @Override
    public int setTitleBarBg() {
        return R.color.color_128EE8;
    }
}
