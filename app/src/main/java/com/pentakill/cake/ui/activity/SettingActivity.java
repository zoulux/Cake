package com.pentakill.cake.ui.activity;

import android.os.Bundle;

import com.pentakill.cake.R;
import com.pentakill.cake.db.CakeDao;
import com.pentakill.cake.db.CategoryDao;
import com.pentakill.cake.db.ShopCartDao;

public class SettingActivity extends BaseActivity {
    private static final String TAG = "SettingActivity";

    CategoryDao categoryDao;
    CakeDao cakeDao;
    ShopCartDao shopCartDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


    }

}
