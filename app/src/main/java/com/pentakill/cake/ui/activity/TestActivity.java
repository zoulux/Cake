package com.pentakill.cake.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.pentakill.cake.R;
import com.pentakill.cake.db.CakeDao;
import com.pentakill.cake.db.CategoryDao;
import com.pentakill.cake.db.ShopCartDao;
import com.pentakill.cake.model.CakeBean;
import com.pentakill.cake.model.CategoryBean;
import com.pentakill.cake.model.ShopCartBean;

import java.io.ByteArrayOutputStream;
import java.util.List;

/**
 * Created by zoulux on 2016-02-04  22:59.
 */
public class TestActivity extends BaseActivity {
    CategoryDao categoryDao;
    CakeDao cakeDao;
    ShopCartDao shopCartDao;

    private static final String TAG = "TestActivity";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);


        setContentView(R.layout.activity_setting);
        categoryDao = new CategoryDao(this);
        cakeDao = new CakeDao(this);
        shopCartDao = new ShopCartDao(this);


        addToShopCart();


    }

    private void addToShopCart() {
        CakeBean cakeBean1 = cakeDao.selectByNumber("sg002");
        ShopCartBean shopCartBean1 = new ShopCartBean(cakeBean1, "8", "118", "不要巧克力");
        shopCartDao.add(shopCartBean1);

        CakeBean cakeBean2 = cakeDao.selectByNumber("sg005");
        ShopCartBean shopCartBean2 = new ShopCartBean(cakeBean2, "8", "118", "不要巧克力,谢谢");
        shopCartDao.add(shopCartBean2);


    }

    private void printCake() {
        List<CakeBean> cakeBeans = cakeDao.selectAll();
        for (CakeBean bean : cakeBeans) {
            Log.d(TAG, "printCake: " + bean.toString());
        }


    }

    private void addCake() {
        String general = "8%%118%%适合2-4人,10%%168%%适合4-6人,12%%218%%适合6-9人,14%%278%%适合9-12人,14%%278%%适合9-12人,16%%358%%适合9-12人,";

        CategoryBean categoryBean = categoryDao.selectByName("水果蛋糕");
        cakeDao.add("sg001", "多彩生活", categoryBean, general, "城区免费送货上门110", R.drawable.p001, R.drawable.default_img, R.drawable.default_img);

        cakeDao.add("sg002", "幸福生活", categoryBean, general, "城区免费送货上门220", R.drawable.p002, R.drawable.default_img, R.drawable.default_img);

        cakeDao.add("sg003", "卡布奇诺", categoryBean, general, "城区免费送货上门330", R.drawable.p003, R.drawable.default_img, R.drawable.default_img);

        cakeDao.add("sg004", "花样生活", categoryBean, general, "城区免费送货上门440", R.drawable.p004, R.drawable.default_img, R.drawable.default_img);

        cakeDao.add("sg005", "热带雨林", categoryBean, general, "城区免费送货上门550", R.drawable.p005, R.drawable.default_img, R.drawable.default_img);

        cakeDao.add("sg006", "激情岁月", categoryBean, general, "城区免费送货上门660", R.drawable.p006, R.drawable.default_img, R.drawable.default_img);


    }

    private void printCategory() {
        List<CategoryBean> categoryBeans = categoryDao.selectAll();
        for (CategoryBean bean : categoryBeans) {
            Log.d(TAG, "onCreate: " + bean.toString());
        }
    }


    private void addCategory() {
        Bitmap bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pshuig);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] res = baos.toByteArray();
        categoryDao.add(new CategoryBean("水果蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pxiann);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("鲜奶蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pertong);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("儿童蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pluo);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("裸蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pzhus);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("祝寿蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.pjier);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("节日蛋糕", res));

        bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + R.drawable.phunq);
        baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        res = baos.toByteArray();
        categoryDao.add(new CategoryBean("婚礼蛋糕", res));


    }
}
