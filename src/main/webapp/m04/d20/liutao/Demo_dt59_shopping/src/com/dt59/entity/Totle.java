/**
 * Project Name:Demo_dt59_shopping
 * File Name:Totle.java
 * Package Name:com.dt59.entity
 * Date:2018年4月23日下午3:52:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月23日 下午3:52:11 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Totle {
    private int spid;

    private String spname;

    private int spcount;

    private float spprice;

    private String spdesc;

    private float sptotle;

    public Totle() {

    }

    public Totle(int spid, String spname, int spcount, float spprice, String spdesc, float sptotle) {
        this.spid = spid;
        this.spname = spname;
        this.spcount = spcount;
        this.spprice = spprice;
        this.spdesc = spdesc;
        this.sptotle = sptotle;

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

    public int getSpcount() {
        return spcount;
    }

    public void setSpcount(int spcount) {
        this.spcount = spcount;
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

    public float getSptotle() {
        return sptotle;
    }

    public void setSptotle(float sptotle) {
        this.sptotle = sptotle;
    }

}
