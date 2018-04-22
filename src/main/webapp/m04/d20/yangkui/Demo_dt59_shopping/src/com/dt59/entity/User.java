/**
 * Project Name:Demo_dt59_shopping
 * File Name:User.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午4:08:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午4:08:24 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class User {
    private int uid;

    private String uname;

    private String upwd;

    public User(){}
    
    public User(String uname, String upwd) {
        super();
        this.uname = uname;
        this.upwd = upwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

}
