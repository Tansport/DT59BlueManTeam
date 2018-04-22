/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月19日下午3:38:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.MingXi;
import com.dt59.entity.ShangPin;
import com.dt59.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午3:38:54 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
    
 List<ShangPin> getAllShangPin();
 
 boolean validateUser(User user);
 
 ShangPin getShangpinById(int id);
 
 List<MingXi> getAllMingXi();
}

