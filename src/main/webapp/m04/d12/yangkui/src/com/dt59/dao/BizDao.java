/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月12日下午6:56:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.News;

import com.dt59.entity.Product;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午6:56:39 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();
    
    List<Product> getAllProduct();
}

