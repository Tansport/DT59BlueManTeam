/**
 * Project Name:Demo_dt59_jspCh10_shopping
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月19日下午2:03:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Shangping;
import com.dt59.entity.User;
import com.dt59.service.Bizservice;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午2:03:41 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BizServiceImpl implements Bizservice {
    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    @Override
    public List<Shangping> getAllShangping() {

        // Auto-generated method stub
        return bizDao.getAllShangping();
    }

    @Override
    public boolean vaildateUser(User user) {

        // Auto-generated method stub
        return bizDao.vaildateUser(user);
    }

    @Override
    public Shangping getShangpingById(int id) {

        // Auto-generated method stub
        return bizDao.getShangpingById(id);
    }

}
