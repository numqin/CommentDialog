package com.qinlei.text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * Created by ql on 2017/4/28.
 */

public class BackEditText extends android.support.v7.widget.AppCompatEditText {
    public interface PressBackCallBack {
        void callBack();
    }

    private PressBackCallBack callBack;

    public void setCallBack(PressBackCallBack callBack) {
        this.callBack = callBack;
    }

    public BackEditText(Context context) {
        super(context);
    }

    public BackEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (callBack != null) {
                callBack.callBack();
            }
            return true;
        }
        return super.dispatchKeyEventPreIme(event);
    }
}
