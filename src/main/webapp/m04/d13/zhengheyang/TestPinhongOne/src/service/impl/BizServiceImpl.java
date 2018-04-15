/**
 * Project Name:TestPinhongOne
 * File Name:BizServiceImpl.java
 * Package Name:service.impl
 * Date:Apr 15, 20183:15:00 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package service.impl;

import java.util.List;

import dao.BizDao;
import entity.News;
import service.BizService;

/**
 * Description: <br/>
 * Date: Apr 15, 2018 3:15:00 PM <br/>
 * 
 * @author zhengheyang
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

    public List<News> getAllNews() {
        return bizDao.getAllNews();
    }

}
