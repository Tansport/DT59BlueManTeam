/**
 * Project Name:lession1
 * File Name:BizDao.java
 * Package Name:d03.m29.dao
 * Date:2018年3月30日下午8:45:28
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m29.dao;

import java.util.List;

import d03.m29.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午8:45:28 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public interface BizDao<T> {
    List<QuestionInfo> getAllInfo();

    List<QuestionInfo> getAllInfo(int i);

    List<QuestionInfo> getAllInfo(String str);

    int saveInfo(T t);

    int deleteInfo(int id);

    List<QuestionInfo> callprocedure();

    List<QuestionInfo> callprocedure2(String str);
}
