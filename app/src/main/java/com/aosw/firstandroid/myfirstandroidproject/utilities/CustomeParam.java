package com.aosw.firstandroid.myfirstandroidproject.utilities;

import android.util.Log;

import com.loopj.android.http.RequestParams;

import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

/**
 * Created by Administrator on 2015/9/24.
 */
public class CustomeParam {

    private TreeMap<String, String> NecessaryParams = new TreeMap<>();

    private TreeMap<String, String> NotNecessaryParams = new TreeMap<>();

    public void putParam(String strKey, String strValue, boolean blIsNecessary) {

        if (blIsNecessary) {
            NecessaryParams.put(strKey, strValue);
        } else {
            NotNecessaryParams.put(strKey, strValue);
        }
    }

    public RequestParams GetRequestParam() {
        RequestParams param = new RequestParams();

        StringBuilder sbChkSource = new StringBuilder();

        sbChkSource.append("woaixizaopifuhaohao");

        NecessaryParams.put("appid","50000");
        NecessaryParams.put("version","1.0.0");

        for (String key :
                NecessaryParams.keySet()) {
            Log.i("key", key);

            sbChkSource.append(key);
            sbChkSource.append(NecessaryParams.get(key));

            param.put(key, NecessaryParams.get(key));
        }

        Log.i("ChkSource", sbChkSource.toString());

        String strChk = SecurityHelper.getMD5FromString(sbChkSource.toString());

        param.put("chk", strChk);

        for (String key :
                NotNecessaryParams.keySet()) {
            param.put(key, NotNecessaryParams.get(key));
        }

        return param;
    }

}
