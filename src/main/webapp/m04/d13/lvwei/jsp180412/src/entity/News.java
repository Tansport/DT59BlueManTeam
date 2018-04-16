/**
 * Project Name:jsp180412
 * File Name:News.java
 * Package Name:entity
 * Date:2018年4月12日下午8:02:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午8:02:25 <br/>
 * 
 * @author lvwei
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

    public void setNdate(Date string) {
        this.ndate = string;
    }

}
