/**
 * Project Name:study
 * File Name:QuestionInfoDao.java
 * Package Name:com.test.dao
 * Date:2018年3月28日下午10:53:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.util.List;
import com.test.entity.QuestionInfo;






/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午10:53:14 <br/>
 * @author   liutao
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    //1.查询所有
    List<QuestionInfo> getAllQuery();
    //2.依据科目查询
    List<QuestionInfo> getSubject(int nu);
    //3.模糊查询
    List<QuestionInfo> getLike(String str);
    //4.添加新的试题
     int updataInfo(T t);
     //5.删除
     int deleteInfo(int dd);

}

