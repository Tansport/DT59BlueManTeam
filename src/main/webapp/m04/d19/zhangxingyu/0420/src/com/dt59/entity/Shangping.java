/**
 * Project Name:Demo_dt59_jspCh10_shopping_01
 * File Name:Shangping.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午12:11:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:11:06 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Shangping implements java.io.Serializable {
    private Integer spid;

    private String spname;

    private Float spprice;

    private String spdesc;

    private int up = 1;

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public Shangping() {
    }

    public Shangping(Integer spid) {
        this.spid = spid;
    }

    public Shangping(Integer spid, String spname, Float spprice, String spdesc) {
        this.spid = spid;
        this.spname = spname;
        this.spprice = spprice;
        this.spdesc = spdesc;
    }

    public Integer getSpid() {
        return this.spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return this.spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public Float getSpprice() {
        return this.spprice;
    }

    public void setSpprice(Float spprice) {
        this.spprice = spprice;
    }

    public String getSpdesc() {
        return this.spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

    // Auto-generated method stub

}
