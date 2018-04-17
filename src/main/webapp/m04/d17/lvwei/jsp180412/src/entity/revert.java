/**
 * Project Name:jsp180412
 * File Name:revert.java
 * Package Name:entity
 * Date:2018年4月16日下午3:30:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午3:30:59 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class revert {
    private int rid;

    private int mid;

    private String rcontent;

    private String rname;

    private Date rdate;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

}
