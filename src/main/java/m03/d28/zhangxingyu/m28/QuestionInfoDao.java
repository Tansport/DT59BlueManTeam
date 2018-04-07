/**
 * Project Name:lession1
 * File Name:QuestionInfoDao.java
 * Package Name:d03.m28
 * Date:2018年3月28日下午5:13:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m28;

import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:13:41 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @param <T>
 * @see
 */
public interface QuestionInfoDao<T> {
    List<QuestionInfo> getAllInfo();

    int updateInfo(T t);

    int deleteInfo(int id);

    int saveInfo2(T t);
}
