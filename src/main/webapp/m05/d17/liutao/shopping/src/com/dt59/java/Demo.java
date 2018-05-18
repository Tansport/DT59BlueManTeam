/**
 * Project Name:shopping
 * File Name:Demo.java
 * Package Name:com.dt59.java
 * Date:2018年5月17日下午4:52:57
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dt59.dao.BizDao;
import com.dt59.pojo.User;
import com.dt59.service.impl.BizServiceimpl;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description: <br/>
 * Date: 2018年5月17日 下午4:52:57 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Demo {

    @Test
    public void show() {
        GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

        SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

        SqlSession sqlsession = ssf.openSession();

        BizDao bizdao = sqlsession.getMapper(BizDao.class);

        BizServiceimpl bsi = new BizServiceimpl();
        bsi.setBizdao(bizdao);
        User us = new User();
        us.setUserCode("admin");
        us.setUserPassword("123456");
        List<User> list = bsi.validateUser(us);
        System.out.println("list:" + list.size());

    }
}
