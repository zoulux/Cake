package com.pentakill.cake.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.pentakill.cake.R;
import com.pentakill.cake.common.listener.PopupListener;
import com.pentakill.cake.db.CakeDao;
import com.pentakill.cake.db.CategoryDao;
import com.pentakill.cake.db.ShopCartDao;
import com.pentakill.cake.db.ShopDao;
import com.pentakill.cake.model.CategoryBean;
import com.pentakill.cake.ui.adapter.CategorySettingAdapter;
import com.pentakill.cake.ui.widget.ExpandableListView;
import com.pentakill.cake.ui.widget.SelectPicPW;

import java.util.List;

public class SettingActivity extends BaseActivity implements View.OnClickListener, PopupListener {
    private static final String TAG = "SettingActivity";

    private CategoryDao categoryDao;
    private ShopDao shopDao;
    private CakeDao cakeDao;
    private ShopCartDao shopCartDao;

    private ExpandableListView listView;
    private CategorySettingAdapter adapter;
    private List<CategoryBean> data;

    private EditText etShopName;
    private EditText etShopPhone;
    private TextView tvSetShopIcon;

private SelectPicPW selectShopIconPW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initDaos();
        initViews();
        initDatas();

    }

    private void initDaos() {
        categoryDao = new CategoryDao(this);
        shopDao = new ShopDao(this);
        shopDao.add();
    }

    private void initDatas() {
        data = categoryDao.selectAll();
        adapter.setData(data);
    }

    private void initViews() {
        listView = (ExpandableListView) findViewById(R.id.lv_category_setting);
        etShopName = (EditText) findViewById(R.id.et_category_name);
        tvSetShopIcon = (TextView) findViewById(R.id.tv_set_shop_icon);
        etShopPhone= (EditText) findViewById(R.id.et_category_phone);


        adapter = new CategorySettingAdapter(this, R.layout.item_category_setting);
        listView.setAdapter(adapter);

        etShopName.setHint(shopDao.getShopName());

        tvSetShopIcon.setOnClickListener(this);


        selectShopIconPW =new SelectPicPW(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_set_shop_icon:
                setShopIcon(v);
                break;
        }

    }

    private void setShopIcon(View v) {
        selectShopIconPW.showAtLocation(v, Gravity.BOTTOM,0,0);
        selectShopIconPW.setListener(this);
    }


    @Override
    public void onSelectByAlbum() {
        Log.d(TAG, "onSelectByAlbum: ");
    }

    @Override
    public void onSelectByCamera() {
        Log.d(TAG, "onSelectByCamera: ");
    }


}



