/**
 * Project Name:workJSP
 * File Name:BizDao.java
 * Package Name:dao
 * Date:2018年4月3日下午11:08:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao;

import java.util.List;

import entity.shangping;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午11:08:32 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public interface BizDao {

    List<shangping> getallshangpingList();

    boolean User(String name, String upwd);

    shangping getshagshangpin(int spid);
}
