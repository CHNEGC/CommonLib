package com.mh.lib_base.util;

import android.view.View;

public class SingleClickListener implements View.OnClickListener {
    private long mLastClickTime = 0L;
    private OnClickListener listener;

    public SingleClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        long time = System.currentTimeMillis();
        if (Math.abs(time - mLastClickTime) < 1000) {
            return;
        }
        mLastClickTime = time;

        if (null != this.listener) {
            this.listener.onClick(view);
        }
    }

   public interface OnClickListener {
        void onClick(View view);
    }
}
