/**
 * Project Name:Jsp
 * File Name:UserInfo.java
 * Package Name:entity
 * Date:2018年4月6日下午9:48:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午9:48:48 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class UserInfo {
    private int userid;

    private String username;

    private String password;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}