/**
 * Project Name:Demo_dt59_pinhong
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:2018年4月13日下午11:07:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午11:07:58 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Page {
    private int currentpage;// 当前页

    private int pagesize = 3;// 每页条数

    private int lastpage;// 尾页

    private int sumsize;// 总条数

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

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

    public int getSumsize() {
        return sumsize;
    }

    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }

}
