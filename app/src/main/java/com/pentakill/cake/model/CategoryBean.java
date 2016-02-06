package com.pentakill.cake.model;

import android.graphics.BitmapFactory;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by zoulux on 2016-02-03  0:07.
 */
@DatabaseTable(tableName = "tb_category")
public class CategoryBean {

    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "res",dataType = DataType.BYTE_ARRAY)
    private byte[] res;

public CategoryBean(){}

    public CategoryBean(String name, byte[] res) {
        this.name = name;
        this.res = res;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getRes() {
        return res;
    }

    public void setRes(byte[] res) {
        this.res = res;
    }
}
