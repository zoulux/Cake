package com.pentakill.cake.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.pentakill.cake.model.ShopCartBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by zoulux on 2016-02-03  23:28.
 */
public class ShopCartDao {
    private Context context;
    private DatabaseHelper helper;
    private Dao<ShopCartBean,Integer> shopCartOpe;


    public ShopCartDao(Context context) {
        this.context = context;
        helper=DatabaseHelper.getInstance(context);

        try {
            shopCartOpe=helper.getDao(ShopCartBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(ShopCartBean shopCartBean)
    {
        try {
            shopCartOpe.create(shopCartBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(ShopCartBean shopCartBean)
    {
        try {
            shopCartOpe.delete(shopCartBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public void update(ShopCartBean shopCartBean)
    {
        try {
            shopCartOpe.update(shopCartBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void clear(){
        List<ShopCartBean> shopCartBeans = selectAll();
        try {
            shopCartOpe.delete(shopCartBeans);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ShopCartBean> selectAll(){




        try {
            return shopCartOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
