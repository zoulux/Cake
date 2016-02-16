package com.pentakill.cake.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by zoulux on 2016-02-14  23:28.
 */

@DatabaseTable(tableName = "tb_shop")
public class ShopBean {

    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(dataType = DataType.BYTE_ARRAY, columnName = "shop_icon")
    private byte[] shopIcon;

    @DatabaseField(columnName = "shop_name",defaultValue = "一块面包")
    private String shopName;

    @DatabaseField(columnName = "shop_phone",defaultValue = "800 8208801")
    private String shopPhone;


    public ShopBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(byte[] shopIcon) {
        this.shopIcon = shopIcon;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }
}
