package com.pentakill.cake.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by zoulux on 2016-02-03  0:49.
 */
@DatabaseTable(tableName = "tb_shop_cart")
public class ShopCartBean implements Serializable{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true,canBeNull = true,columnName = "cake_id")
    private CakeBean cake;

    @DatabaseField(columnName = "selectSize")
    private String selectSize;

    @DatabaseField(columnName = "selectPrice")
    private String selectPrice;

    @DatabaseField(columnName = "remark")
    private String remark;  //备注


    public ShopCartBean(){}

    public ShopCartBean(CakeBean cake, String size, String price, String remark) {
        this.cake = cake;
        this.selectSize = size;
        this.selectPrice = price;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ShopCartBean{" +
                "id=" + id +
                ", cake=" + cake +
                ", selectSize='" + selectSize + '\'' +
                ", selectPrice='" + selectPrice + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
