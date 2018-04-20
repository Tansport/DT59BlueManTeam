/**
 * Project Name:Demo_dt59_jspCh10_shopping_01
 * File Name:User.java
 * Package Name:com.dt59.entity
 * Date:2018年4月19日下午3:11:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.io.Serializable;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午3:11:39 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class User implements Serializable {
    private Integer uid;

    private String uname;

    private String upwd;

    public User() {
    }

    public User(Integer uid) {
        this.uid = uid;
    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User(Integer uid, String uname, String upwd) {
        this.uid = uid;
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
