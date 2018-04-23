/**
 * Project Name:Demo_dt59_shangpin
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月19日下午3:11:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Shangpin;
import com.dt59.entity.User;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午3:11:38 <br/>
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
    public List<Shangpin> getAllShangpin() {

        // Auto-generated method stub
        return bizDao.getAllShangpin();
    }

    @Override
    public boolean validateUser(User user) {

        // Auto-generated method stub
        return bizDao.validateUser(user);
    }

    @Override
    public Shangpin getSpInfoById(int id) {

        // Auto-generated method stub
        return bizDao.getSpInfoById(id);
    }

}
