/**
 * Project Name:jsp180412
 * File Name:User.java
 * Package Name:entity
 * Date:2018年4月13日下午4:26:31
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午4:26:31 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class User {
    private int uid;

    private String uname;

    private String upwd;

    private String ustatus;

    private String upic;

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

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String string) {
        this.ustatus = string;
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic;
    }
}
