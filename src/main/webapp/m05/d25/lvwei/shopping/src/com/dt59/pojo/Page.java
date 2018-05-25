/**
 * Project Name:shopping
 * File Name:Page.java
 * Package Name:com.dt59.pojo
 * Date:2018年5月21日下午2:50:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.pojo;

/**
 * Description: <br/>
 * Date: 2018年5月21日 下午2:50:47 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Page {
    private int currentpage; // 当前页

    private int pagesize = 3;// 每页显示3条数据

    private int sizecount;// 总条数

    private int lastpage;// 尾页

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage <= 0) {
            this.currentpage = 1;
        } else {
            if (currentpage > this.lastpage) {
                this.currentpage = this.lastpage;
            } else {
                this.currentpage = currentpage;
            }
        }
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSizecount() {
        return sizecount;
    }

    public void setSizecount(int sizecount) {
        this.sizecount = sizecount;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

}
