/**
 * Project Name:Demo_dt59_jsp06_04_12
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018��4��12������6:56:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.News;
import com.dt59.entity.Product;

/**
 * Description: <br/>
 * Date: 2018��4��12�� ����6:56:18 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();

    List<Product> getALLProduct();
}
