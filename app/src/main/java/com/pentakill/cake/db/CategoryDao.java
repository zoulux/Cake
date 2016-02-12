package com.pentakill.cake.db;

import android.content.Context;
import android.graphics.Bitmap;

import com.j256.ormlite.dao.Dao;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.pentakill.cake.model.CakeBean;
import com.pentakill.cake.model.CategoryBean;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by zoulux on 2016-02-03  23:04.
 */
public class CategoryDao {
    private Context context;
    private DatabaseHelper helper;
    private Dao<CategoryBean, Integer> categoryDaoOpe;

    public CategoryDao(Context context) {
        this.context = context;
        helper = DatabaseHelper.getInstance(context);

        try {
            categoryDaoOpe = helper.getDao(CategoryBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(CategoryBean categoryBean) {
        try {
            categoryDaoOpe.create(categoryBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(CategoryBean categoryBean) {
        try {
            categoryDaoOpe.delete(categoryBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByName(String name) {
        CategoryBean categoryBean = selectByName(name);
        if (categoryBean!=null)
        {
            delete(categoryBean);
        }
    }

    public List<CategoryBean> selectAll() {
        try {

            return categoryDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public CategoryBean selectByName(String name) {
        List<CategoryBean> categoryBeans = null;
        try {
            categoryBeans = categoryDaoOpe.queryForEq("name", name.trim());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (categoryBeans != null && categoryBeans.size() > 0) {
            return categoryBeans.get(0);
        }
        return null;

    }

    public Collection<CakeBean> getFruitByName(String name){
        CategoryBean bean = selectByName(name);
        return  bean.getCakes();
    }

    public void update(CategoryBean newCategoryBean) {
        try {
            categoryDaoOpe.update(newCategoryBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加载drawable下的文件
     * @param name
     * @param resId
     */
    public void add(String name,int resId) {

        Bitmap bitmap = ImageLoader.getInstance().loadImageSync("drawable://" + resId);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();

        CategoryBean categoryBean=new CategoryBean(name,bytes);
        add(categoryBean);
    }


    public void clear() {
        List<CategoryBean> categoryBeans = selectAll();
        try {
            categoryDaoOpe.delete(categoryBeans);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
