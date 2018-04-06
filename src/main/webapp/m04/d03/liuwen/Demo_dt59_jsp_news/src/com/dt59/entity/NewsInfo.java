/**
 * Project Name:Demo_dt59_jsp_news
 * File Name:NewsInfo.java
 * Package Name:com.dt59.entity
 * Date:2018年4月3日下午10:06:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午10:06:01 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
// 新闻类实体
public class NewsInfo {
    private String newstitle;

    private String newsauthor;

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewsauthor() {
        return newsauthor;
    }

    public void setNewsauthor(String newsauthor) {
        this.newsauthor = newsauthor;
    }

}
