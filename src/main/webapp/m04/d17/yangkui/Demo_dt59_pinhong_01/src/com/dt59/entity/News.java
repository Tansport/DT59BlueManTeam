/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:News.java
 * Package Name:com.dt59.entity
 * Date:2018年4月12日下午7:00:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:00:07 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class News {
    private int nid;
    private String ntitle;
    private String ncontent;
    private Date ndate;
    public int getNid() {
        return nid;
    }
    public void setNid(int nid) {
        this.nid = nid;
    }
    public String getNtitle() {
        return ntitle;
    }
    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }
    public String getNcontent() {
        return ncontent;
    }
    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }
    public Date getNdate() {
        return ndate;
    }
    public void setNdate(Date ndate) {
        this.ndate = ndate;
    } 
}

