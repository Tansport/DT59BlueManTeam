/**
 * Project Name:Demo_jdbc_fc
 * File Name:BizDao.java
 * Package Name:dao
 * Date:2018年3月28日下午4:38:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao;

import java.util.List;

import entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:38:35 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao<T> {
    //查询列表
    List<QuestionInfo> getAllInfo();
    //查询科目
    List<QuestionInfo> getAllInfo(int i);
    //按题干模糊查询
    List<QuestionInfo> getAllInfo(String a);
    //添加
    int saveQuestionInfo(T t);

    // 删除试题
    int deleteInfo(int id);
    
    
}

