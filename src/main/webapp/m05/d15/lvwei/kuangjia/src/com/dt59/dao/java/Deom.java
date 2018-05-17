/**
 * Project Name:kuangjia
 * File Name:Deom.java
 * Package Name:com.dt59.dao.java
 * Date:2018年5月14日下午4:25:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.java;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;
import com.dt59.pojo.stu4;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午4:25:12 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Deom {
    BizDaoImpl bdi = new BizDaoImpl();

    GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

    SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

    SqlSession sqlsession = ssf.openSession(false);

    BizDao bizdao = sqlsession.getMapper(BizDao.class);

    @Test
    public void show() {
        BizDaoImpl bdi = new BizDaoImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入编号");
        int id = sc.nextInt();
        Stu stu = bdi.getStuId(id);
        System.out.println(stu.getId() + "\t" + stu.getName());
    }

    @Test
    public void show2() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("name", "鲁智深");
        Stu stu = bdi.getStubyMap(map);
        System.out.println(stu.getId() + "\t" + stu.getName());
    }

    @Test
    public void show3() {
        Stu stu = new Stu();
        stu.setId(1);
        stu.setName("鲁智深");
        Stu tt = bdi.getStuEntity(stu);
        System.out.println(tt.getId() + "\t" + tt.getName());
    }

    @Test
    public void show4() {
        List<HashMap<String, Object>> list = bdi.getAllStu();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String tt : allkey) {
                System.out.println(tt + "\t" + map.get(tt) + "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void show5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的关键字：");
        String name = sc.next();
        List<HashMap<String, Object>> list = bdi.getAllStulike(name);
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String tt : allkey) {
                System.out.println(tt + "\t" + map.get(tt) + "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void show6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的关键字：");
        String name = sc.next();
        List<HashMap<String, Object>> list = bdi.getAllStulike2(name);
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String tt : allkey) {
                System.out.println(tt + "\t" + map.get(tt) + "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void show7() {

        BizDao bizdao = sqlsession.getMapper(BizDao.class);
        List<HashMap<String, Object>> list = bizdao.getnuminfo();
        System.out.println("list:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String tt : allkey) {
                System.out.println(tt + "\t" + map.get(tt) + "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void show8() {
        try {
            Scanner sc = new Scanner(System.in);
            Stu stu = new Stu();
            System.out.println("请输入姓名");
            stu.setName(sc.next());
            int i = bizdao.addinfo(stu);
            sqlsession.commit();
            System.out.println(i);
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

    @Test
    public void show9() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入需要删除的id");
            int id = sc.nextInt();
            int i = bizdao.delInfoById(id);
            sqlsession.commit();
            System.out.println(i);
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

    @Test
    public void show10() {
        try {
            List<Stu> list = bizdao.getAllinfo();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getId() + "\t" + list.get(i).getName() + "\t"
                        + list.get(i).getStu4().getAname());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

    @Test
    public void show11() {
        try {
            List<stu4> list = bizdao.getAllStu4();
            for (int i = 0; i < list.size(); i++) {
                stu4 stu4 = list.get(i);
                Set<Stu> set = stu4.getStuu();
                for (Stu stu : set) {
                    System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu4.getAname());
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

}
