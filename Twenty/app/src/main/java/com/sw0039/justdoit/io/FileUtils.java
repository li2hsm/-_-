package com.sw0039.justdoit.io;

import android.os.Environment;

import java.io.File;

/**
 * 文件工具类
 */
public class FileUtils {

    /**
     * 获取sdcard的路径
     * @return
     */
    public static String getSdCardPath() {
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);//判断sd卡是否存在
        if (sdCardExist) {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }
}
