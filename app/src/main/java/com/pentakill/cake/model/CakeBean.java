package com.pentakill.cake.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by zoulux on 2016-02-02  23:59.
 */
@DatabaseTable(tableName = "tb_cake")
public class CakeBean implements Serializable {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "number",unique = true)
    private String number; //编号

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "res", dataType = DataType.BYTE_ARRAY)
    private byte[] res;

    @DatabaseField(canBeNull = true, foreign = true, columnName = "category_id",foreignAutoRefresh = true)
    private CategoryBean category;//类别

    @DatabaseField(columnName = "size_price", defaultValue = "00%%00%%适合2-4人")
    private String general;        //所有的尺寸和价格和适合多少人吃

    @DatabaseField(columnName = "desc1", dataType = DataType.BYTE_ARRAY)
    private byte[] desc1;  //描述的图片1

    @DatabaseField(columnName = "desc2", dataType = DataType.BYTE_ARRAY)
    private byte[] desc2;  //描述的图片2

    @DatabaseField(columnName = "des_text")
    private String desText;//下方描述的文字



    public CakeBean() {
    }


    public CakeBean(String number, String name, CategoryBean category,String sizeAndPrice,String desText, byte[] res,  byte[] desc1, byte[] desc2) {
        this.number = number;
        this.name = name;
        this.res = res;
        this.category = category;
        this.general = sizeAndPrice;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desText=desText;
    }


    public String getDesText() {
        return desText;
    }

    public void setDesText(String desText) {
        this.desText = desText;
    }

    public byte[] getDesc1() {
        return desc1;
    }

    public void setDesc1(byte[] desc1) {
        this.desc1 = desc1;
    }

    public byte[] getDesc2() {
        return desc2;
    }

    public void setDesc2(byte[] desc2) {
        this.desc2 = desc2;
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

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    @Override
    public String toString() {
        return "CakeBean{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", general='" + general + '\'' +
                ", desText='" + desText + '\'' +
                ", res=" + Arrays.toString(res) +
                ", desc1=" + Arrays.toString(desc1) +
                ", desc2=" + Arrays.toString(desc2) +
                '}';
    }
}
