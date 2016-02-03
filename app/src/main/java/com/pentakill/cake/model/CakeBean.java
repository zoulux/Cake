package com.pentakill.cake.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by zoulux on 2016-02-02  23:59.
 */
@DatabaseTable(tableName = "tb_cake")
public class CakeBean {

    @DatabaseField(generatedId = true)
    private  int id;

    @DatabaseField(columnName ="number" )
    private String number; //编号

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "res",dataType = DataType.BYTE_ARRAY)
    private byte[] res;

    @DatabaseField(canBeNull = true,foreign = true,columnName = "category_id")
    private CategoryBean category;//类别

    @DatabaseField(columnName ="size_price",defaultValue ="00%%00" )
    private String sizeAndPrice;        //所有的尺寸和价格

    public CakeBean(){}

    public CakeBean(String number, String name, byte[] res, CategoryBean category, String sizeAndPrice) {
        this.number = number;
        this.name = name;
        this.res = res;
        this.category = category;
        this.sizeAndPrice = sizeAndPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

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

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public String getSizeAndPrice() {
        return sizeAndPrice;
    }

    public void setSizeAndPrice(String sizeAndPrice) {
        this.sizeAndPrice = sizeAndPrice;
    }
}
