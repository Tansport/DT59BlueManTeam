/**
 * Project Name:Demo_dt59_jspCh10_shopping_01
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月19日下午12:05:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Shangping;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:05:13 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public interface BizDao {
    List<Shangping> getAllShangping();

    boolean vaildateUser(User user);

    Shangping getShangpingById(int id);
}
