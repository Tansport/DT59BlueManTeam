/**
 * Project Name:Demo_jdbc_fc
 * File Name:BizDao.java
 * Package Name:dao
 * Date:2018年3月28日下午4:38:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:38:35 <br/>
 * 
 * @author
 * @version
 * @see
 */
public interface BizDao<T> {
    // 查询所有试题
    List<QuestionInfo> getAllInfo();

    // 根据输入的int型数据，查询科目
    List<QuestionInfo> getAllInfo(int i);

    // 根据输入题干，模糊查询
    List<QuestionInfo> getAllInfo(String str);

    // 增加试题
    int saveQuestionInfo(T t);

    // 删除试题
    int deleteInfo(int id);
}
