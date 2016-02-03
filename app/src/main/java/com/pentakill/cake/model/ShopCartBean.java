package com.pentakill.cake.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by zoulux on 2016-02-03  0:49.
 */
@DatabaseTable(tableName = "tb_shop_cart")
public class ShopCartBean {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true,canBeNull = true,columnName = "cake_id")
    private CakeBean cake;

    @DatabaseField(columnName = "size")
    private String size;

    @DatabaseField(columnName = "price")
    private String price;

    @DatabaseField(columnName = "remark")
    private String remark;  //备注


    public ShopCartBean(){}

    public ShopCartBean(CakeBean cake, String size, String price, String remark) {
        this.cake = cake;
        this.size = size;
        this.price = price;
        this.remark = remark;
    }
}
