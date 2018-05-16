/**
 * Project Name:Demo.dt59.ordl_02
 * File Name:Stu.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月15日上午11:27:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

/**
 * Description: <br/>
 * Date: 2018年5月15日 上午11:27:48 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class Stu {
    private int sid;

    private String sname;

    private int sage;

    private String scard;

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

    public String getScard() {
        return scard;
    }

    public void setScard(String scard) {
        this.scard = scard;
    }

   
}
