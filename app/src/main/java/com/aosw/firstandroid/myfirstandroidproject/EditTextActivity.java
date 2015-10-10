package com.aosw.firstandroid.myfirstandroidproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Administrator on 2015/10/9.
 */
public class EditTextActivity extends Activity {

    private EditText editTextFirst;

    private Button editTextFirstButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);

        // 对EditText添加图片或表情
        setupImageToEditText();
    }

    // 对EditText添加图片或表情
    private void setupImageToEditText() {
        editTextFirst = (EditText) this.findViewById(R.id.edittext_first);
        editTextFirstButton = (Button) this.findViewById(R.id.edittext_first_Button);

        editTextFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomId = 1 + new Random().nextInt(4);

                try {
                    Field field = R.mipmap.class.getDeclaredField("qq" + String.valueOf(randomId));

                    int resourceid = Integer.parseInt(field.get(null).toString());

                    // 在android中要显示图片信息，必须使用Bitmap（位图） 的对象来装载
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resourceid);

                    ImageSpan imagespan = new ImageSpan(EditTextActivity.this, bitmap);

                    SpannableString spannableString = new SpannableString("face");
                    spannableString.setSpan(imagespan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    editTextFirst.append(spannableString);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}