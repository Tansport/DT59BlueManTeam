/**
 * Project Name:study
 * File Name:QuestionInfoDao.java
 * Package Name:com.test.dao
 * Date:2018年3月28日下午4:18:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.util.List;

import com.test.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:18:09 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    // 1.查询所有
    List<QuestionInfo> getAllQuery();

    // 2.查询科目
    List<QuestionInfo> getsubject(int num);

    // 3.题干模糊查询
    List<QuestionInfo> getLike(String str);

    // 4.添加试题
    int uppdata(T t);

    // 5.删除试题
    int delete(int questionId);

    // 调用存储过程查询，查询所有试题
    List<QuestionInfo> callprodedure();

    // 调用存储过程,对题干模糊查询
    List<QuestionInfo> callprocedure2(String str);

    // 退出系统

}
