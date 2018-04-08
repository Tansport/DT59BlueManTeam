/**
 * Project Name:workJSP
 * File Name:comment_info.java
 * Package Name:entity
 * Date:2018年4月8日下午10:23:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午10:23:34 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class comment_info {
    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
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

    public int getNewsid() {
        return newsid;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public Date getFbtime() {
        return fbtime;
    }

    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }

    private int commentid;

    private String username;

    private String ip;

    private String content;

    private int newsid;

    private Date fbtime;
}
