/**
 * Project Name:workspace1
 * File Name:DAO.java
 * Package Name:lession180328.dao
 * Date:2018年3月28日下午5:03:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.lvwei.src.lession180328.dao;

import java.util.List;

import m03.d28.lvwei.src.lession180328.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:03:24 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public interface QuestionInfoDao<T> {
    int deleteInfo(int id);

    int saveInfo2(T t);

    List<QuestionInfo> getAllInfo();

    List<QuestionInfo> getjava();

    List<QuestionInfo> getC();

    List<QuestionInfo> getJSP();

    List<QuestionInfo> getcont(String cont);
}
