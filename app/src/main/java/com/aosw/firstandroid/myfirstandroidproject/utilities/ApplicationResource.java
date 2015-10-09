package com.aosw.firstandroid.myfirstandroidproject.utilities;

import android.app.Application;

/**
 * Created by Administrator on 2015/9/22.
 */
public class ApplicationResource extends Application {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String msg;

    @Override
    public void onCreate() {
        super.onCreate();
        setMsg("刚刚调用了ApplicationResource的onCreate()方法");
    }
}
