package com.aosw.firstandroid.myfirstandroidproject.utilities;

import android.util.Log;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2015/9/24.
 */
public class SecurityHelper {

    // 获取16进制MD5加密字符串
    public static String getMD5FromString(String strSource) {
        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] m = md5.digest(strSource.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < m.length; i++) {
                int intVal = ((int) m[i]) & 0xff;
                if (intVal < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(intVal));
            }

            return sb.toString();
        } catch (Exception ex) {
            Log.e("计算md5出错", ex.toString());
            return "";
        }

    }
}
