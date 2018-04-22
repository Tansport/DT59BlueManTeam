/**
 * Project Name:Demo_dt59_shopping
 * File Name:User.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午2:41:50
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午2:41:50 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class User {
    private Integer uid;

    private String uname;

    private String upwd;

    public User() {

    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
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
