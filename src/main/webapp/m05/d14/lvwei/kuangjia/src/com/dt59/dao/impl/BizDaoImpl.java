/**
 * Project Name:kuangjia
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018��5��14������11:29:29
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
 * Date: 2018��5��14�� ����11:29:29 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class BizDaoImpl implements BizDao {
    GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

    SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

    SqlSession sqlsession = ssf.openSession();

    @Override
    // ������ѯ
    public List<Stu> getStu() {

        // Auto-generated method stub

        // ����sqlsession��ֻҪ�ǳ־ò㶼��Ҫһ����νsession�Ľӿڣ���ɾ�Ĳ飬���洫ͳjdbc��Ԥ���룩

        List<Stu> list = null;
        try {
            list = sqlsession.selectList("sqlmappper.getStu");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

        return list;
    }

    @Override
    // ������������ѯ
    public Stu getStuId(int id) {
        Stu stu = null;
        try {
            stu = sqlsession.selectOne("sqlmappper.getStuId", id);
            // SqlSession sqlsession = ssf.openSession();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return stu;
    }

    @Override
    // �����������ѯ��hashmap����
    public Stu getStubyMap(HashMap<String, Object> map) {
        Stu stu = null;
        try {

            stu = sqlsession.selectOne("sqlmappper.getStubyMap", map);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return stu;
    }

    @Override
    // �����������ֵ����������ѯ
    public Stu getStuEntity(Stu stu) {
        Stu tt = null;
        try {
            tt = sqlsession.selectOne("sqlmappper.getStuEntity", stu);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return tt;
    }

    @Override
    public List<HashMap<String, Object>> getAllStu() {
        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmappper.getAllStu");
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
    public List<HashMap<String, Object>> getAllStulike(String name) {

        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmappper.getAllStulike", name);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        // Auto-generated method stub
        return list;
    }

    public List<HashMap<String, Object>> getAllStulike2(String name) {

        List<HashMap<String, Object>> list = null;
        try {
            list = sqlsession.selectList("sqlmappper.getAllStulike2", name);
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
