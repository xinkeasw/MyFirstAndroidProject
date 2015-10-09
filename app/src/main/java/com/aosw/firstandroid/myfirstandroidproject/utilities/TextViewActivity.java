package com.aosw.firstandroid.myfirstandroidproject.utilities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.aosw.firstandroid.myfirstandroidproject.R;

/**
 * Created by Administrator on 2015/10/9.
 */
public class TextViewActivity extends Activity {

    private TextView marqueeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        // 跑马灯效果代码
        showMarqueeTextView();
    }

    private void showMarqueeTextView() {
        // 跑马灯效果
        String marqueeText = "<a href='http://www.baidu.com'>点我跳转到百度</a>我是跑马灯的<font color='write'>效果</font>啊，<strong>你看到了没有！！！</strong>我有一头小毛驴，我从来也不骑，有一天我心血来潮，骑它去赶集";

        CharSequence marqueeCharSequence = Html.fromHtml(marqueeText);

        marqueeTextView = (TextView) this.findViewById(R.id.marquee_textview);
        marqueeTextView.setText(marqueeCharSequence);
        marqueeTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
