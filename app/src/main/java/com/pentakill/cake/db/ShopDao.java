package com.pentakill.cake.db;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.j256.ormlite.dao.Dao;
import com.pentakill.cake.model.ShopBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zoulux on 2016-02-14  23:31.
 */
public class ShopDao {
    private Context context;
    private DatabaseHelper helper;
    private Dao<ShopBean, Integer> shopOpe;

    public ShopDao(Context context) {
        this.context = context;
        helper = DatabaseHelper.getInstance(context);

        try {
            shopOpe = helper.getDao(ShopBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(){
        if (select()==null){

            ShopBean bean=new ShopBean();
            try {
                shopOpe.create(bean);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    public void update(ShopBean bean) {
        try {
            shopOpe.update(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ShopBean select() {
        try {
            List<ShopBean> shopBeens = shopOpe.queryForAll();
            if (shopBeens != null && shopBeens.size() != 0)
                return shopBeens.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Bitmap getShopPic() {
        ShopBean bean = select();
        byte[] bytes = bean.getShopIcon();
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    public String getShopName() {
        ShopBean bean = select();
        return bean.getShopName();
    }

    public String getShopPhone() {
        ShopBean bean = select();
        return bean.getShopPhone();
    }


    public void setShopName(String name) {
        ShopBean bean = select();
        bean.setShopName(name);
        update(bean);
    }

    public void setShopPhone(String phone) {
        ShopBean bean = select();
        bean.setShopPhone(phone);
        update(bean);
    }

}
