package com.pentakill.cake.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by zoulux on 2016-02-03  0:07.
 */
@DatabaseTable(tableName = "tb_category")
public class CategoryBean implements Serializable{

    @DatabaseField(generatedId = true)
    private int id;


    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "res", dataType = DataType.BYTE_ARRAY)
    private byte[] res;

    @ForeignCollectionField(eager = false,columnName ="cakes" )
    private Collection<CakeBean> cakes;



    public CategoryBean() {
    }

    public CategoryBean(String name, byte[] res) {
        this.name = name;
        this.res = res;
    }

    public CategoryBean(CategoryBean categoryBean) {
        this.id=categoryBean.id;
        this.name=categoryBean.name;
        this.res=categoryBean.res;
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


    public Collection<CakeBean> getCakes() {
        return cakes;
    }

    public void setCakes(Collection<CakeBean> cakes) {
        this.cakes = cakes;
    }

    @Override
    public String toString() {
        return "CategoryBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
             //   ", res=" + Arrays.toString(res) +
                '}';
    }
}
