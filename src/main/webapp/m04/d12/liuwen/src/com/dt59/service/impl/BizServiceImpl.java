/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月12日下午7:16:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:16:53 <br/>
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
    public List<News> getAllNews() {

        // Auto-generated method stub
        return bizDao.getAllNews();
    }

    @Override
    public List<Product> getAllProducts() {

        // Auto-generated method stub
        return bizDao.getAllProducts();
    }

}
