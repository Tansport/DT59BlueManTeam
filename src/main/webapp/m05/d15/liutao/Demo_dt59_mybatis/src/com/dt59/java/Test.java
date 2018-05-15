/**
 * Project Name:Demo_dt59_mybatis
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年5月14日下午2:58:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionFactory;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午2:58:34 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test {
    GetSqlSessionFactory gsf = GetSqlSessionFactory.getInstance();

    SqlSessionFactory ssf = gsf.getSqlSessionFactory1();

    SqlSession sqlsession = ssf.openSession();

    BizDao bizdao = sqlsession.getMapper(BizDao.class);

    @org.junit.Test
    public void show1() {
        List<HashMap<String, Object>> list = bizdao.getStuCount();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> set = map.keySet();
            for (String string : set) {
                System.out.print(map.get(string) + "\t");

            }
            System.out.println();

        }

    }

    @org.junit.Test
    public void show2() {
        try {

            Stu stu = new Stu();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入姓名:");
            stu.setSname(sc.next());
            System.out.println("请输入年龄:");
            stu.setSage(sc.nextInt());
            System.out.println("请输入卡号:");
            stu.setScard(sc.nextInt());
            System.out.println("请输入年级编号:");
            // stu.setSgid(sc.nextInt());//因多对一查询注释
            int flag = bizdao.getInsert(stu);
            sqlsession.commit();// 提交
            System.out.println("结果：" + flag);
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();// 回滚
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

    @org.junit.Test
    public void show3() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入删除的id号");
            int id = scan.nextInt();
            int flag = bizdao.deleteId(id);
            sqlsession.commit();
            System.out.println(flag);

        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();

        } finally {
            sqlsession.close();
        }

    }

    @org.junit.Test
    public void show4() {
        List<Stu> list = bizdao.getAllStu();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getSid() + "\t" + list.get(i).getSname() + "\t" + list.get(i).getSage()
                    + "\t" + list.get(i).getGrade().getGname());

        }

    }

    @org.junit.Test
    public void show5() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入编号");
        Set<Stu> ss = bizdao.getStu(scan.nextInt());
        // System.out.println(ss);
        /*
         * for (Stu stu : ss) { System.out.println(stu + "\t"); }
         */
        System.out.println(ss.size());

    }
}
