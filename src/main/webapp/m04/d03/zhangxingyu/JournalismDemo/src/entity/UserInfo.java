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
    private int id;

    private String name;

    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}