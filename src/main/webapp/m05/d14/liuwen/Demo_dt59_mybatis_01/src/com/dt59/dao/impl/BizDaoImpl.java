/**
 * Project Name:Demo_dt59_mybatis_01
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年5月14日下午3:30:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午3:30:53 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class BizDaoImpl implements BizDao {
    GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

    SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

    SqlSession sqlsession = ssf.openSession();

    @Override
    public List<Stu> getStu() {

        List<Stu> list = null;
        try {
            list = sqlsession.selectList("sqlmapper.getStu");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getAllStu() {
        List<HashMap<String, Object>> list = null;

        try {
            list = sqlsession.selectList("sqlmapper.getAllStu");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return list;
    }

    @Override
    public Stu getStuById(int id) {

        Stu stu = null;
        try {
            stu = sqlsession.selectOne("sqlmapper.getStuById", id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return stu;
    }

}
