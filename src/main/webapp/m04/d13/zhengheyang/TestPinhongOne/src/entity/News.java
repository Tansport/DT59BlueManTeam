/**
 * Project Name:TestPinhongOne
 * File Name:News.java
 * Package Name:entity
 * Date:Apr 15, 20182:59:08 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     Apr 15, 2018 2:59:08 PM <br/>
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

