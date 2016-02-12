package com.pentakill.cake.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pentakill.cake.R;

public class SplashActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View  view=getLayoutInflater().inflate(R.layout.activity_splash,null);

        setContentView(view);

        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,TestActivity.class);
        startActivity(intent);
    }
}
