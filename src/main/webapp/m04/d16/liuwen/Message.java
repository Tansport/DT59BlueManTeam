/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Message.java
 * Package Name:com.dt59.entity
 * Date:2018年4月16日下午6:09:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午6:09:54 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Message {
    private int mid;

    private String mtitle;

    private String mcontent;

    private String mname;

    private String mdate;

    private int rcount;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

}
