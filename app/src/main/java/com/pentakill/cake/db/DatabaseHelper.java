package com.pentakill.cake.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.pentakill.cake.model.CakeBean;
import com.pentakill.cake.model.CategoryBean;
import com.pentakill.cake.model.ShopCartBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zoulux on 2016-02-02  23:56.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TABLE_NAME = "cake.db";
    private static final int DATABASE_VERSION = 1;
    private Map<String, Dao> daos = new HashMap<>();
    private static DatabaseHelper instance;


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, CakeBean.class);
            TableUtils.createTable(connectionSource, CategoryBean.class);
            TableUtils.createTable(connectionSource, ShopCartBean.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, CakeBean.class, true);
            TableUtils.dropTable(connectionSource, CategoryBean.class, true);
            TableUtils.dropTable(connectionSource, ShopCartBean.class, true);

            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseHelper getInstance(Context context) {
        context = context.getApplicationContext();
        if (instance == null)
            synchronized (DatabaseHelper.class) {
                if (instance == null)
                    instance = new DatabaseHelper(context);
            }
        return instance;
    }

    public Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className))
            dao = daos.get(className);

        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao=daos.get(key);
            dao=null;

        }
    }
}
