package com.mh.lib_base.view;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.mh.lib_base.R;
import com.mh.lib_base.util.DisplayUtil;
import com.mh.lib_base.util.SingleClickListener;

public class TitleBarView extends ConstraintLayout {
    public TitleBarView(Context context) {
        this(context, null);
    }

    public TitleBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private ImageView titleBtnBack;
    private TextView titleTvTitle;
    private View titleViewBar;

    private void init(Context context) {
        inflate(context, R.layout.view_title_layout, this);

        titleBtnBack = findViewById(R.id.titleBtnBack);
        titleTvTitle = findViewById(R.id.titleTvTitle);
        titleViewBar = findViewById(R.id.titleViewBar);

        ViewGroup.LayoutParams layoutParams = titleViewBar.getLayoutParams();
        layoutParams.height = DisplayUtil.getStatusBarHeight(context);
        titleViewBar.setLayoutParams(layoutParams);
    }

    public void setOnBackFinish(SingleClickListener listener) {
        titleBtnBack.setOnClickListener(listener);
    }

    public void setOnTitle(String title) {
        titleTvTitle.setText(title);
    }

    public void setTitleViewBarBg(@ColorRes int color) {
        titleViewBar.setBackgroundColor(getResources().getColor(color));
    }

    public void setTitleBarBg(@ColorRes int colorId) {
        setBackgroundResource(colorId);
    }
}
