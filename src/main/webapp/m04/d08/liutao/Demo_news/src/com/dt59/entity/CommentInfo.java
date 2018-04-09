/**
 * Project Name:Demo_news
 * File Name:CommentInfo.java
 * Package Name:com.dt59.entity
 * Date:2018年4月8日下午10:50:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午10:50:57 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class CommentInfo {
    private int comment_id;

    private String username;

    private String ip;

    private String content;

    private int news_id;

    private Date fbtime;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public Date getFbtime() {
        return fbtime;
    }

    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }

}
