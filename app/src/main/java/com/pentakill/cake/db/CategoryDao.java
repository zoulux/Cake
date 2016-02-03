package com.pentakill.cake.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.pentakill.cake.model.CategoryBean;

import java.sql.SQLException;
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
        try {
            List<CategoryBean> categoryBeans = categoryDaoOpe.queryForEq("name", name);
            if (categoryBeans != null && categoryBeans.size() > 0) {
                delete(categoryBeans.get(0));
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

    public void  update(CategoryBean newCategoryBean)
    {
        try {
            categoryDaoOpe.update(newCategoryBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
