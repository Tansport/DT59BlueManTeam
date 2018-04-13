/**
 * Project Name:TestPinhong0
 * File Name:News.java
 * Package Name:com.java.entity
 * Date:Apr 12, 20187:45:12 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.java.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     Apr 12, 2018 7:45:12 PM <br/>
 * @author   zhengheyang
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

