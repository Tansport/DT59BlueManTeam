/**
 * Project Name:Demo_news
 * File Name:Page.java
 * Package Name:com.dt59.entity
 * Date:2018年4月10日上午9:58:45
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午9:58:45 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Page {
    private int currentpage;// 当前页

    private int pagesize = 3;// 每页显示的条数

    private int sumpage;// 总条数

    private int lastpage;// 尾页

    private List<NewsInfo> newsinfo;// 新闻消息集合

    public int getCurrentpage() {
        if (currentpage <= 1) {
            return 1;
        } else if (currentpage >= 3) {
            return 3;
        }
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        if (currentpage > 0) {
            this.currentpage = currentpage;
        }
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        if (pagesize > 0) {
            this.pagesize = pagesize;
        }

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

    public List<NewsInfo> getNewsinfo() {
        return newsinfo;
    }

    public void setNewsinfo(List<NewsInfo> newsinfo) {
        this.newsinfo = newsinfo;
    }

}
