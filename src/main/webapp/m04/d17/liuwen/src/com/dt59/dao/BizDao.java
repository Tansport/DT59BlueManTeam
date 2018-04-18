/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月12日下午6:57:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.Revert;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午6:57:39 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProducts();

    boolean validateUser(User user);

    List<User> getAllUsers();

    String getUstatus(User user);

    List<Product> getAllProductsByPage(Page page);

    List<Message> getAllMessages();

    List<Message> getMessageById(int id);

    List<Revert> getRevertById(int id);

    // 获取产品的总条数，为分页准备
    int getProductNumber();

    // 获取回复更新的条数
    int getUpdateRepaly(int mid, String rcontent, String rname);
}
