package com.pentakill.cake.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.pentakill.cake.model.CakeBean;
import com.pentakill.cake.model.CategoryBean;

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


    public void update(CakeBean cakeBean){
        try {
            cakeDaoOpe.update(cakeBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
