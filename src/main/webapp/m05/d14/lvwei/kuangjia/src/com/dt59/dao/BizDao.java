/**
 * Project Name:kuangjia
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018��5��14������11:24:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018��5��14�� ����11:24:51 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public interface BizDao {
    List<Stu> getStu();

    Stu getStuId(int id);

    Stu getStubyMap(HashMap<String, Object> map);

    Stu getStuEntity(Stu stu);

    List<HashMap<String, Object>> getAllStu();

    List<HashMap<String, Object>> getAllStulike(String name);

    List<HashMap<String, Object>> getAllStulike2(String name);
}
