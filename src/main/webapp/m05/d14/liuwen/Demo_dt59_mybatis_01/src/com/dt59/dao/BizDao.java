/**
 * Project Name:Demo_dt59_mybatis_01
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日下午3:29:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午3:29:29 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public interface BizDao {
    List<Stu> getStu();

    List<HashMap<String, Object>> getAllStu();

    Stu getStuById(int id);
}
