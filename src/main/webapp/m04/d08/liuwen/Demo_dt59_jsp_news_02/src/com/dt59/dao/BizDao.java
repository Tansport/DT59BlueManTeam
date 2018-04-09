/**
 * Project Name:Demo_dt59_jsp_news
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月3日下午3:11:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:11:20 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public interface BizDao {
    boolean validateUser(UserInfo user);

    List<NewsInfo> getNews();

    int delNewsInfoById(int id);

    List<CommentInfo> getComments();
}
