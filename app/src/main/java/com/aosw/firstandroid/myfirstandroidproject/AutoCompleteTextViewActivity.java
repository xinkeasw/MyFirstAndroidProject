package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

/**
 * Created by Administrator on 2015/10/12.
 */
public class AutoCompleteTextViewActivity extends Activity {

    private AutoCompleteTextView autoTextFirst;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        // 初始化控件
        initiAutoControl();
    }

    // 初始化自动完成控件
    private void initiAutoControl() {
        autoTextFirst = (AutoCompleteTextView) this.findViewById(R.id.autoTextFirst);

        String[] autoString = new String[]{"aa", "bb", "aabb", "aabbcc", "aabbccdd"};

        // 第二个参数表示适配器的下拉风格
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AutoCompleteTextViewActivity.this,
                android.R.layout.simple_dropdown_item_1line, autoString);

        autoTextFirst.setAdapter(adapter);


        //
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) this.findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(adapter);
        // 完成对选项的拆分功能，以逗号进行分隔
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
