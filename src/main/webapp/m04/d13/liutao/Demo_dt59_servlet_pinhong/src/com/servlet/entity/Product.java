/**
 * Project Name:Demo_servlet_pinhong
 * File Name:Product.java
 * Package Name:com.servlet.entity
 * Date:2018年4月12日下午6:55:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet.entity;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午6:55:52 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Product {
    private int pid;

    private String pname;

    private String pbrand;

    private String pmodel;

    private double pprice;

    private String ppicture;

    private String pdes;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public String getPmodel() {
        return pmodel;
    }

    public void setPmodel(String pmodel) {
        this.pmodel = pmodel;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public String getPpicture() {
        return ppicture;
    }

    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

}
