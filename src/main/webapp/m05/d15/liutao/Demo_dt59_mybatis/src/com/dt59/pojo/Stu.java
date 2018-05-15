/**
 * Project Name:Demo_mybatis
 * File Name:Stu.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月14日上午10:30:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午10:30:47 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Stu {
    private int sid;

    private String sname;

    private int sage;

    private int scard;

    // private int sgid;
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getScard() {
        return scard;
    }

    public void setScard(int scard) {
        this.scard = scard;
    }

    /*
     * public int getSgid() { return sgid; }
     * 
     * public void setSgid(int sgid) { this.sgid = sgid; }
     */

}
