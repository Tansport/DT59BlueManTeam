/**
 * Project Name:Demo_dt59_jsp_news
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月3日下午3:30:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:30:38 <br/>
 * 
 * @author WEN LIU
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
    public boolean validateUser(UserInfo user) {

        // Auto-generated method stub
        return bizDao.validateUser(user);
    }

    @Override
    public List<NewsInfo> validateNewsInfo(NewsInfo newsinfo) {

        // Auto-generated method stub
        return bizDao.validateNewsInfo(newsinfo);
    }

}
