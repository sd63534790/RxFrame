package com.example.cy.rxframe.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by cy on 2017/12/21.
 */

public class Constants {

    public static final String BUGLY_ID = "e534989ff7";

    public static final String APK = "";

    public static String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "cheny" + File.separator + "RxFrame";


    //cache
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static String PATH_CACHE = PATH_DATA + "/NetCache";
}
