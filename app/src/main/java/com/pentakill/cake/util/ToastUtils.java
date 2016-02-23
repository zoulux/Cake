package com.pentakill.cake.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zoulux on 2016-02-23  22:27.
 */
public class ToastUtils {
    private static Toast mToast;

    public static void showToast(Context context,String txt){
        if (mToast==null)
        {
            mToast=Toast.makeText(context,txt,Toast.LENGTH_SHORT);
        }
        mToast.setText(txt);
        mToast.show();

    }
}
