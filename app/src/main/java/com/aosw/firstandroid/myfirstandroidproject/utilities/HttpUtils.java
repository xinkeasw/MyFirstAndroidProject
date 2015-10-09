package com.aosw.firstandroid.myfirstandroidproject.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2015/9/24.
 */
public class HttpUtils {

    public static void saveImageToDisk(InputStream inputStream) {

        byte[] data = new byte[1024];
        int len = 0;

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream("D:\\test.png",false);
            while ((len = inputStream.read(data)) != -1) {
                fileOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
