/**
 * Project Name:Demo_dt59_servlet_pinhong
 * File Name:Page.java
 * Package Name:com.servlet.entity
 * Date:2018年4月14日下午8:52:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet.entity;

/**
 * Description: <br/>
 * Date: 2018年4月14日 下午8:52:12 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Page {
    private int currentpage;// 当前页面

    private int pagesize = 3;// 每页显示条数

    private int sumpage;// 总条数

    private int lastpage;// 尾页

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage < 1) {
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

    public int getSumpage() {
        return sumpage;
    }

    public void setSumpage(int sumpage) {
        this.sumpage = sumpage;
        if (sumpage > 0) {
            lastpage = ((this.sumpage % pagesize == 0) ? (this.sumpage / pagesize) : (this.sumpage / pagesize + 1));
        }
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

}
