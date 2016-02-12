package com.pentakill.cake.db;

import android.content.Context;
import android.graphics.Bitmap;

import com.j256.ormlite.dao.Dao;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pentakill.cake.model.CakeBean;
import com.pentakill.cake.model.CategoryBean;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zoulux on 2016-02-03  22:49.
 */
public class CakeDao {
    private Context context;
    private Dao<CakeBean, Integer> cakeDaoOpe;
    private DatabaseHelper helper;


    public CakeDao(Context context) {
        this.context = context;

        helper = DatabaseHelper.getInstance(context);

        try {
            cakeDaoOpe = helper.getDao(CakeBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(CakeBean cakeBean) {
        try {
            cakeDaoOpe.create(cakeBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(CakeBean cakeBean) {
        try {
            cakeDaoOpe.delete(cakeBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteById(int id) {
        try {
            cakeDaoOpe.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CakeBean> selectAll() {

        try {
            return cakeDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CakeBean> selectByCategory(CategoryBean categoryBean) {
        try {
            return cakeDaoOpe.queryForEq("category_id", categoryBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByNumber(String number) {
        CakeBean bean = selectByNumber(number);
        if (bean != null) {
            delete(bean);
        }

    }

    public CakeBean selectByNumber(String number) {
        try {
            List<CakeBean> cakeBeans = cakeDaoOpe.queryForEq("number", number);

            if (cakeBeans != null && cakeBeans.size() > 0) {
                return cakeBeans.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(CakeBean cakeBean) {
        try {
            cakeDaoOpe.update(cakeBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载drawable下的文件
     *
     * @param name
     * @param resId
     */
    public void add(String number, String name, CategoryBean category, String sizeAndPrice, String desText, int imgResId, int desImgId1, int desImgId2) {

        Bitmap res = ImageLoader.getInstance().loadImageSync("drawable://" + imgResId);
        Bitmap des1 = ImageLoader.getInstance().loadImageSync("drawable://" + desImgId1);
        Bitmap des2 = ImageLoader.getInstance().loadImageSync("drawable://" + desImgId2);
        ByteArrayOutputStream baosRes = new ByteArrayOutputStream();
        ByteArrayOutputStream baosDes1 = new ByteArrayOutputStream();
        ByteArrayOutputStream baosDes2 = new ByteArrayOutputStream();

        res.compress(Bitmap.CompressFormat.PNG, 100, baosRes);
        des1.compress(Bitmap.CompressFormat.PNG, 100, baosDes1);
        des2.compress(Bitmap.CompressFormat.PNG, 100, baosDes2);

        byte[] byteRes = baosRes.toByteArray();
        byte[] byteDes1 = baosDes1.toByteArray();
        byte[] byteDes2 = baosDes2.toByteArray();

        CakeBean cakeBean = new CakeBean(number, name, category, sizeAndPrice, desText, byteRes, byteDes1, byteDes2);
        add(cakeBean);
    }

    public void clear() {
        List<CakeBean> cakeBeans = selectAll();
        try {
            cakeDaoOpe.delete(cakeBeans);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
