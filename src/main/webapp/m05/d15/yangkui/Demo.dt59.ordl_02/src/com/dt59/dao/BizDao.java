/**
 * Project Name:Demo.dt59.ordl_02
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月15日上午11:18:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.dt59.pojo.Grade;
import com.dt59.pojo.Stu;

/**
 * Description:   <br/>
 * Date:     2018年5月15日 上午11:18:52 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
    List<HashMap<String, Object>> getStudent();
    
    int addStudent(Stu stu);
    
    int delStu(int sid);
    
    List<Stu> getAllStu();
    
    Set<Stu> getStu(int id);
}

