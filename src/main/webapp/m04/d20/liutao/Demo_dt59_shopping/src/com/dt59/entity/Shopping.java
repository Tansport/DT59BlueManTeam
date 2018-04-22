/**
 * Project Name:Demo_dt59_shopping
 * File Name:Shopping.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午12:16:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:16:50 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Shopping {
    private Integer spid;

    private String spname;

    private String spprice;

    private String spdesc;

    private int num = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getSpprice() {
        return spprice;
    }

    public void setSpprice(String spprice) {
        this.spprice = spprice;
    }

    public String getSpdesc() {
        return spdesc;
    }

    public void setSpdesc(String spdesc) {
        this.spdesc = spdesc;
    }

}
