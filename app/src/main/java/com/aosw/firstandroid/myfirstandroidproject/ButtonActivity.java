package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Created by Administrator on 2015/10/22.
 */
public class ButtonActivity extends Activity implements OnClickListener, OnTouchListener, OnFocusChangeListener, OnKeyListener {

    // 用于改变按钮的大小
    private int value = 1;

    private Button buttonFirst;
    private Button buttonImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        buttonFirst = (Button) this.findViewById(R.id.button_first);
        buttonImage = (Button) this.findViewById(R.id.button_image);

        buttonFirst.setOnClickListener(this);

        buttonImage.setOnClickListener(this);
        buttonImage.setOnTouchListener(this);
        buttonImage.setOnFocusChangeListener(this);
        buttonImage.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        Rect rect = new Rect();
        getWindowManager().getDefaultDisplay().getRectSize(rect);
        if (value == 1 && button.getWidth() == rect.width()) {
            button.setText("点我会变小");
            value = -1;
        } else if (value == -1 && button.getWidth() < 100) {
            button.setText("点我会变大");
            value = 1;
        }

        button.setWidth(button.getWidth() + (int) (button.getWidth() * 0.1) * value);
        button.setHeight(button.getHeight() + (int) (button.getHeight() * 0.1 * value));
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            buttonImage.setText("获得焦点");
        } else {
            buttonImage.setText("失去焦点");
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Button button = (Button) v;

        if (KeyEvent.ACTION_DOWN == event.getAction()) {
            button.setText("Key Down");
        } else if (KeyEvent.ACTION_UP == event.getAction()) {
            button.setText("Key Up");
        }

        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Button button = (Button) v;
        if (event.getAction() == MotionEvent.ACTION_UP) {
            button.setText("抬起手指了呢");

        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            button.setText("正在点击屏幕吧");
        }
        return false;
    }
}