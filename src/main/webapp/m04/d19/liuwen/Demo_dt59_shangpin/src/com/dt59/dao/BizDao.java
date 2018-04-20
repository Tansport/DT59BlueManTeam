/**
 * Project Name:Demo_dt59_shangpin
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月19日下午12:09:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Shangpin;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:09:09 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public interface BizDao {

    List<Shangpin> getAllShangpin();

    boolean validateUser(User user);

    Shangpin getSpInfoById(int id);
}
