package com.pentakill.cake.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
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
    private TextView tvSetShopIcon, tvSetShopName, tvSetShopMobile;
    private ImageView ivShopIcon;

    private SelectPicPW selectShopIconPW;
    private int REQUEST_CODE_CAPTURE_CAMEIA = 0x1;
    private int REQUEST_CODE_PICK_IMAGE = 0x2;

    private ImageView ivTheme1, ivTheme2, ivTheme3, ivTheme4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initDaos();
        initViews();
        initListener();
        initDatas();

    }

    private void initListener() {
        tvSetShopIcon.setOnClickListener(this);
        ivTheme1.setOnClickListener(this);
        ivTheme2.setOnClickListener(this);
        ivTheme3.setOnClickListener(this);
        ivTheme4.setOnClickListener(this);
        tvSetShopName.setOnClickListener(this);
        tvSetShopMobile.setOnClickListener(this);

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
        tvSetShopIcon = (TextView) findViewById(R.id.tv_update_shop_mobile);
        etShopPhone = (EditText) findViewById(R.id.et_category_phone);
        ivShopIcon = (ImageView) findViewById(R.id.iv_shop_icon);
        ivTheme1 = (ImageView) findViewById(R.id.iv_theme1);
        ivTheme2 = (ImageView) findViewById(R.id.iv_theme2);
        ivTheme3 = (ImageView) findViewById(R.id.iv_theme3);
        ivTheme4 = (ImageView) findViewById(R.id.iv_theme4);
        tvSetShopName = (TextView) findViewById(R.id.tv_update_shop_name);
        tvSetShopMobile = (TextView) findViewById(R.id.tv_update_shop_mobile);


        adapter = new CategorySettingAdapter(this, R.layout.item_category_setting);
        listView.setAdapter(adapter);

        etShopName.setHint(shopDao.getShopName());
        etShopPhone.setHint(shopDao.getShopPhone());
        selectShopIconPW = new SelectPicPW(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_update_shop_icon:
                setShopIcon(v);
                break;
            case R.id.iv_theme1:
                changeTheme(1);
                break;
            case R.id.iv_theme2:
                changeTheme(2);
                break;
            case R.id.iv_theme3:
                changeTheme(3);
                break;
            case R.id.iv_theme4:
                changeTheme(4);
                break;
            case R.id.tv_update_shop_name:
                updateName();
                break;
            case R.id.tv_update_shop_mobile:
                updateMobile();
                break;

        }

    }

    private void updateMobile() {
        String name = etShopName.getText().toString();
        if (!TextUtils.isEmpty(name)){
        shopDao.setShopName(name);
        }
    }

    private void updateName() {
        String phone = etShopPhone.getText().toString();
        if (!TextUtils.isEmpty(phone)){
            shopDao.setShopPhone(phone);
        }
    }

    private void changeTheme(int themeType) {
        showToast(themeType + "");

    }

    private void setShopIcon(View v) {
        selectShopIconPW.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        selectShopIconPW.setListener(this);
    }


    @Override
    public void onSelectFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);

        Log.d(TAG, "onSelectFromAlbum: ");
    }

    @Override
    public void onSelectFromCamera() {
        Log.d(TAG, "onSelectFromCamera: ");

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, REQUEST_CODE_CAPTURE_CAMEIA);
        } else {
            showToast("请确认已经插入SD卡");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            showToast("请再试一遍");
            return;
        }

        if (requestCode == REQUEST_CODE_PICK_IMAGE) {
            Uri uri = data.getData();
            ImageLoader.getInstance().displayImage(uri.toString(), ivShopIcon);
        } else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA) {
            Uri uri = data.getData();
            Bitmap bitmap = null;
            if (uri == null) {
                Bundle bundle = data.getExtras();
                bitmap = (Bitmap) bundle.get("data");
                ivShopIcon.setImageBitmap(bitmap);
            } else {
                ImageLoader.getInstance().displayImage(uri.toString(), ivShopIcon);
            }
        }


    }
}



