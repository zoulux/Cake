package com.pentakill.cake.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by zoulux on 2016-1-31-0031.
 */
public class BaseActivity extends AppCompatActivity {
    private static Toast mToast;

    protected void showToast(String txt) {
        if (mToast == null) {
            mToast = Toast.makeText(this, txt, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(txt);
        }

        mToast.show();
    }

}
