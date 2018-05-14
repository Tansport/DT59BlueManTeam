/**
 * Project Name:Demo.dt59.orcl02
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年5月14日下午2:12:42
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
 * Description:   <br/>
 * Date:     2018年5月14日 下午2:12:42 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl implements BizDao{
    GetSqlSessionUtil gsu= GetSqlSessionUtil.getInstance();
    SqlSessionFactory ssf= gsu.getsqlsessionfactory_();
    SqlSession sqlsession=ssf.openSession();
    @Override
    public List<Stu> getStu() {
        List<Stu> list=null;
        try {
            list=sqlsession.selectList("sqlmapper.getStu");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            sqlsession.close();
        }
        return list;
    }
    @Override
    public List<HashMap<String, Object>> getAllStu() {
        List<HashMap<String, Object>> list=null; 
        //  Auto-generated method stub
        try {
            list=sqlsession.selectList("sqlmapper.getAllStu");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
        return list;
    }
    @Override
    public List<HashMap<String, Object>> getAllStuByLike(String name) {
        
        List<HashMap<String, Object>> list=null;
        try {
            list=sqlsession.selectList("sqlmapper.getAllStuByLike",name);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
        return list;
    }
    @Override
    public List<Stu> addStu() {
        List<Stu> list=null;
        try {
            list=sqlsession.selectList("sqlmapper.addStu");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            sqlsession.close();
        }
        return list;
    }
}

