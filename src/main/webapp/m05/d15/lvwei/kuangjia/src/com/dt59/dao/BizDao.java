/**
 * Project Name:kuangjia
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日上午11:24:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Stu;
import com.dt59.pojo.stu4;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午11:24:51 <br/>
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

    List<HashMap<String, Object>> getnuminfo();

    int addinfo(Stu stu);

    int delInfoById(int id);

    List<Stu> getAllinfo();

    List<stu4> getAllStu4();
}
