/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月19日下午12:20:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Shopping;
import com.dt59.entity.Totle;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:20:27 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface BizDao {
    // 查询产品清单
    List<Shopping> getAllShopping();

    // 根据账号和密码查询
    boolean getAllUser(User User);

    // 依据sid将商品加入购物车
    Shopping getAllbyId(int sid);

    // 插入数据进入购物车
    int getTotle(Totle totle);

}
