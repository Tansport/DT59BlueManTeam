/**
 * Project Name:Demo_mybatis
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年5月14日上午10:28:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Stu;
import com.dt59.until.GetSqlSession;

/**
 * Description: <br/>
 * Date: 2018年5月14日 上午10:28:29 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizDaoImpl implements BizDao {
    GetSqlSession gss = GetSqlSession.getInstance();

    SqlSessionFactory ssf = gss.getsqlsessionfactory_();

    SqlSession sqlsession = ssf.openSession();

    @Override
    public List<Stu> getAllinfo() {
        List<Stu> list = null;
        // Auto-generated method stub
        try {

            list = sqlsession.selectList("sqlmapper.getAllinfo");

        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getAll() {
        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmapper.getAll");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return list;
    }

    @Override
    public List<HashMap<String, Object>> getLike() {
        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmapper.getLike");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return list;
    }

    @Override
    public Stu getStu(int id) {
        Stu stu = null;

        try {
            stu = sqlsession.selectOne("sqlmapper.getStu", id);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return stu;
    }

    @Override
    public Stu getStuMap(HashMap<String, Object> map) {
        Stu stu = new Stu();
        try {
            stu = sqlsession.selectOne("sqlmapper.getStuMap", map);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return stu;
    }

    public Stu getStuByEntity(Stu stu) {
        // TODO Auto-generated method stub
        Stu tt = null;
        try {
            tt = sqlsession.selectOne("sqlmapper.getStuByEntity", stu);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return tt;
    }

    @Override
    // 插入
    public boolean getInsert(Stu stu) {
        boolean flag = false;
        try {
            int mm = sqlsession.insert("sqlmapper.getInsert", stu);
            sqlsession.commit();
            flag = (mm > 0);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

        // Auto-generated method stub
        return flag;
    }

    @Override
    public List<HashMap<String, Object>> getLikeNum(String name) {
        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmapper", name);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();

        }

        // Auto-generated method stub
        return list;
    }

}
