package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/4.
 */
public class CheckBoxActivity extends Activity implements View.OnClickListener {

    private List<CheckBox> checkBoxes = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_checkbox);
        String[] checkboxText = new String[]{"你是谁", "你从哪里来", "你要到哪里去"};
        // 动态加载布局
        LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_checkbox, null);
        // 给指定的CheckBox赋值
        for (int i = 0; i < checkboxText.length; i++) {
            // 先获得CheckBox.xml的对象
            CheckBox checkBox = (CheckBox) getLayoutInflater().inflate(R.layout.checkbox, null);

            checkBoxes.add(checkBox);
            checkBoxes.get(i).setText(checkboxText[i]);
            // 实现了动态添加CheckBox
            linearLayout.addView(checkBox, i);
        }

        setContentView(linearLayout);

        Button button = (Button) this.findViewById(R.id.checkbox_button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String string = "";
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked()) {
                string += checkBox.getText() + "\n";
            }
        }
        if ("".equals(string)) {
            string = "你还没有选中选项！！";
        }

        // 使用提示框，提示用户选择的CheckBox
        new AlertDialog.Builder(this).setMessage(string).setPositiveButton("关闭", null).show();
    }
}
