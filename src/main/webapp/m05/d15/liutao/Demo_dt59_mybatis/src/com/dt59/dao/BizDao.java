/**
 * Project Name:Demo_dt59_mybatis
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日下午2:24:26
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午2:24:26 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface BizDao {
    List<HashMap<String, Object>> getStuCount();

    int getInsert(Stu stu);

    int deleteId(int id);

    List<Stu> getAllStu();

    Set<Stu> getStu(int id);

}
