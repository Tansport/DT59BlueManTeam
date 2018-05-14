/**
 * Project Name:Demo_mybatis
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年5月14日上午10:28:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午10:28:12 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface BizDao {
    // 查询一个表所有信息
    List<Stu> getAllinfo();

    // 通过id查询学生
    Stu getStu(int id);

    // 多条件查询
    Stu getStuMap(HashMap<String, Object> map);

    // 查询获取实体
    Stu getStuByEntity(Stu stu);

    // 查询2个表的所有信息
    List<HashMap<String, Object>> getAll();

    // 查询多表，显示年级和人数
    List<HashMap<String, Object>> getLike();

    // 插入
    boolean getInsert(Stu stu);

    // 多表模糊查询
    List<HashMap<String, Object>> getLikeNum(String name);

}
