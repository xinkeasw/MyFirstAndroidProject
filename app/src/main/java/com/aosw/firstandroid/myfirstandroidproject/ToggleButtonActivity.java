package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by Administrator on 2015/11/4.
 */
public class ToggleButtonActivity extends Activity {

    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton = (ToggleButton) this.findViewById(R.id.togglebutton);
        final LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.togglebutton_layout);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 设置垂直布局
                    linearLayout.setOrientation(1);
                } else {
                    // 设置水平布局
                    linearLayout.setOrientation(0);
                }

            }
        });
    }
}
