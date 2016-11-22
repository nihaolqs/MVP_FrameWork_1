package com.lqs.fast.mvpframework.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by dell on 2016/11/22.
 */

public class UiUtils {
    private static LayoutInflater sInflater;
    public static void initUiUtils(Context context){
        sInflater = LayoutInflater.from(context);
    }
    public static View inflaterLayout(int res) throws Exception {
        if(sInflater == null){
            throw new Exception("UiUtils没有初始化");
        }
        View view = sInflater.inflate(res,null);
        return view;
    }
}
