/**
 * Project Name:Jsp
 * File Name:BizDao.java
 * Package Name:dao
 * Date:2018年4月6日下午9:44:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao;

import java.util.List;

import entity.NewsInfo;
import entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午9:44:43 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public interface BizDao {

    boolean denglu(UserInfo user);

    List<NewsInfo> all();

    int delNewsInfoById(int id);
}
