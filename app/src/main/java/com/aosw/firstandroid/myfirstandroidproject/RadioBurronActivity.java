package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/11/2.
 */
public class RadioBurronActivity extends Activity {

    private Button buttonYes;

    private RadioGroup radioSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);

        radioSex = (RadioGroup) this.findViewById(R.id.radio_sex);
        buttonYes = (Button) this.findViewById(R.id.radiobutton_button_yes);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 获取单选按钮组的选项个数
                int len = radioSex.getChildCount();
                String msgString = "";
                for (int i = 0; i < len; i++) {
                    RadioButton radioButton = (RadioButton) radioSex.getChildAt(i);

                    if (radioButton.isChecked()) {
                        msgString = radioButton.getText().toString();
                        break;
                    }
                }

                Toast.makeText(RadioBurronActivity.this, msgString, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
