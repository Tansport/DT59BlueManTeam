/**
 * Project Name:Demo_servlet_pinhong
 * File Name:BizDao.java
 * Package Name:com.servlet.basedao
 * Date:2018年4月12日下午7:00:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet.basedao;

import java.util.List;

import com.servlet.entity.News;
import com.servlet.entity.Page;
import com.servlet.entity.Product;
import com.servlet.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:00:56 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface BizDao {
    // 显示news
    List<News> getAllNews();

    // 显示产品
    List<Product> getAllProduct();

    // 显示用户
    Boolean getUserInfo(User user);

    // 得到所有的用户信息
    List<User> getAllUser();

    // 通过账号查询ustaus
    String getUstaus(User user);

    // 总行数查询
    int getSumCount(Page page);

    // 分页显示
    List<Product> getLimitPage(Page page);

}
