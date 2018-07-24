package com.bsh.dt.plccustomize;

import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by XuTe on 2018/5/31.
 */

public class PLCCustomizeApplication extends Application {

    private static PLCCustomizeApplication instance = new PLCCustomizeApplication();
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        mContext = getApplicationContext();

        ZXingLibrary.initDisplayOpinion(this);
    }

    public static PLCCustomizeApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }
}
