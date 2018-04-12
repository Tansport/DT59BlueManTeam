/**
 * Project Name:Testinfo
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:Apr 10, 20182:58:06 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: Apr 10, 2018 2:58:06 PM <br/>
 * 
 * @author zhengheyang
 * @version
 * @see
 */
public class Page {
    private int currentpage;// 当前页数

    private int pagesize = 3;// 每页显示的条数

    private int sumsize; // 总条数

    private int lastpage;// 尾页

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSumsize() {
        return sumsize;
    }

    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }
}
