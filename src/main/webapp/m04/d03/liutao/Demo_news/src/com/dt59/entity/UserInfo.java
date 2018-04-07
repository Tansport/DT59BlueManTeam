/**
 * Project Name:Demo_news
 * File Name:UserInfo.java
 * Package Name:com.dt59.entity
 * Date:2018年4月6日下午10:16:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午10:16:45 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class UserInfo {
    private int id;

    private String name;

    private String psw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
