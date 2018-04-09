/**
 * Project Name:Demo_news
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月7日下午7:23:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月7日 下午7:23:48 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    @Override
    public boolean validateUser(UserInfo ui) {

        return bizDao.validateUser(ui);
    }

    @Override
    public List<NewsInfo> addTitle() {

        return bizDao.addTitle();
    }

    @Override
    public int delNewsInfoById(int id) {

        // Auto-generated method stub
        return bizDao.delNewsInfoById(id);
    }

    @Override
    public List<CommentInfo> showInfo() {

        // Auto-generated method stub
        return bizDao.showInfo();
    }

    @Override
    public int modification(NewsInfo ni) {

        // Auto-generated method stub
        return bizDao.modification(ni);
    }

}
