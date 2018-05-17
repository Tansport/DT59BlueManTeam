/**
 * Project Name:Demo_dt59_mybatis_02
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月15日上午11:13:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Grade;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月15日 上午11:13:54 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public interface BizDao {
    List<HashMap<String, Object>> getStudent();

    int addStudent(Stu stu);

    int delInfoById(int id);

    List<Stu> getAllStu();

    List<Grade> getAllGradeByOne();

}
