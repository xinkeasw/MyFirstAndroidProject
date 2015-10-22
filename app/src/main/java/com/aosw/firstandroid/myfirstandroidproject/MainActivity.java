package com.aosw.firstandroid.myfirstandroidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aosw.firstandroid.myfirstandroidproject.utilities.ApplicationResource;
import com.aosw.firstandroid.myfirstandroidproject.utilities.CustomeParam;
import com.aosw.firstandroid.myfirstandroidproject.utilities.HttpUtils;
import com.aosw.firstandroid.myfirstandroidproject.utilities.SecurityHelper;
import com.aosw.firstandroid.myfirstandroidproject.utilities.TextViewActivity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    private ApplicationResource myAppResource;

    private Button mainButtonTextView;
    private Button mainButtonEditText;
    private Button mainButtonAutoComplete;
    private Button mainButtonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        initializeControls();
//
//        btn = (Button) this.findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                CustomeParam param = new CustomeParam();
//                try {
//                    param.putParam("pwd", SecurityHelper.getMD5FromString("123qwe"), true);
//                } catch (Exception ex) {
//
//                }
//                param.putParam("mobile", "13946011602", true);
//
//                AsyncHttpClient client = new AsyncHttpClient();
//
//                client.get(MainActivity.this, "http://www.68idc.cn/help/uploads/allimg/130810/0F314T39_0.png", param.GetRequestParam(), new AsyncHttpResponseHandler() {
//                    @Override
//                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//
//                        InputStream inputStream = new ByteArrayInputStream(responseBody, 0, 0);
//
//                        HttpUtils.saveImageToDisk(inputStream);
//
//                        Log.i("headers", headers.toString());
//
//                        String strJsonData = null;
//
//                        try {
//                            strJsonData = new String(responseBody, "UTF-8");
//
//
//                            Log.i("ResponseBody", strJsonData);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                        Log.i("返回的结果", strJsonData);
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//                        Log.e("错误", error.toString());
//                    }
//                });
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 初始化控件
    private void initializeControls() {
        // 打开TextView演示界面
        mainButtonTextView = (Button) this.findViewById(R.id.main_button_textview);
        mainButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);

                startActivity(intent);
            }
        });

        // 打开EditView演示界面
        mainButtonEditText = (Button) this.findViewById(R.id.main_button_edittext);
        mainButtonEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });

        // 打开自动完成演示界面
        mainButtonAutoComplete = (Button) this.findViewById(R.id.main_button_autocomplete);
        mainButtonAutoComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AutoCompleteTextViewActivity.class);
                startActivity(intent);
            }
        });

        // 打开Button按钮的焦点变化演示界面
        mainButtonButton = (Button) this.findViewById(R.id.main_button_button);
        mainButtonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}
