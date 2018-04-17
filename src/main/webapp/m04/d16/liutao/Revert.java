/**
 * Project Name:Demo_dt59_servlet_pinhong
 * File Name:Revert.java
 * Package Name:com.servlet.entity
 * Date:2018年4月16日下午9:43:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet.entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午9:43:24 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Revert {
    private int rid;

    private int mid;

    private String rcontent;

    private String rname;

    private Date rdate;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

}
