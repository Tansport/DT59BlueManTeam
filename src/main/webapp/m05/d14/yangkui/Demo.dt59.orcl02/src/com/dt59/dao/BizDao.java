/**
 * Project Name:Demo.dt59.orcl02
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日下午2:02:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Stu;

/**
 * Description:   <br/>
 * Date:     2018年5月14日 下午2:02:38 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
    List<Stu> getStu();
    
    List<HashMap<String,Object>> getAllStu();
    
    List<HashMap<String, Object>> getAllStuByLike(String name);
    
    List<Stu> addStu();
}

