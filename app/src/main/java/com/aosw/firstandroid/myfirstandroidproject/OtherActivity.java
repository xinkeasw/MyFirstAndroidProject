package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Administrator on 2015/9/22.
 */
public class OtherActivity extends Activity {

    private EditText txtShow;

    public  static String Name;
    public static int Age;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        txtShow = (EditText) this.findViewById(R.id.txtMsg);

        txtShow.setText("Name:"+Name+"\n年龄:"+Age);

//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        int intAge = intent.getIntExtra("age", 0);
//        String strAddress = intent.getStringExtra("address");
//
//        String strText = "姓名：" + name + "\r\n年龄：" + intAge + "\r\n地址：" + strAddress;
//
//        Log.i("Text", strText);
//
//        txtShow.setText(strText);

    }
}
