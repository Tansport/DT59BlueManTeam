/**
 * Project Name:Demo_dt59_shangpin
 * File Name:Shangpin.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午12:11:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:11:13 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Shangpin {
    private int spid;

    private String spname;

    private float spprice;

    private String spdesc;

    private int num = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Shangpin() {
        super();
    }

    public Shangpin(int spid, String spname, float spprice, String spdesc) {
        super();
        this.spid = spid;
        this.spname = spname;
        this.spprice = spprice;
        this.spdesc = spdesc;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public float getSpprice() {
        return spprice;
    }

    public void setSpprice(float spprice) {
        this.spprice = spprice;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

}
