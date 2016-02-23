package com.pentakill.cake.ui.activity;

import android.support.v7.app.AppCompatActivity;

import com.pentakill.cake.util.ToastUtils;

/**
 * Created by zoulux on 2016-1-31-0031.
 */
public class BaseActivity extends AppCompatActivity {

    protected void showToast(String txt) {
        ToastUtils.showToast(this, txt);
    }

}
