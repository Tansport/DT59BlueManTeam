/**
 * Project Name:Demo_dt59_mybatis_01
 * File Name:Student.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月14日下午3:38:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午3:38:09 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Stu {
    private int sid;

    private String sname;

    private int sage;

    private String scard;

    // private int sgid;
    private Grade grade;// 对象 声明

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

    public String getScard() {
        return scard;
    }

    public void setScard(String scard) {
        this.scard = scard;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}
