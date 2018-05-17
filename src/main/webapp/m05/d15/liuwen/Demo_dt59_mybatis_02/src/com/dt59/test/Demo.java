/**
 * Project Name:Demo_dt59_mybatis_02
 * File Name:Demo.java
 * Package Name:com.dt59.test
 * Date:2018年5月15日上午11:16:46
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.test;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Grade;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description: <br/>
 * Date: 2018年5月15日 上午11:16:46 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Demo {
    GetSqlSessionUtil gsu = GetSqlSessionUtil.getInstance();

    SqlSessionFactory ssf = gsu.getsqlsessionfactory_();

    SqlSession sqlsession = ssf.openSession(false);

    BizDao bizdao = sqlsession.getMapper(BizDao.class);

    @org.junit.Test
    public void show1() {
        List<HashMap<String, Object>> list = bizdao.getStudent();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String key : allkey) {
                System.out.print(map.get(key) + "\t");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void show2() {
        Scanner sc = new Scanner(System.in);
        try {
            Stu stu = new Stu();
            System.out.println("请输入姓名");
            stu.setSname(sc.next());
            System.out.println("请输入年龄:");
            stu.setSage(sc.nextInt());
            System.out.println("请输入卡号:");
            stu.setScard(sc.next());
            System.out.println("请输入年级编号:");
            // stu.setSgid(sc.nextInt());
            int flag = bizdao.addStudent(stu);
            // 增、删、改 需要添加事物
            sqlsession.commit();
            System.out.println("结果是" + flag);

        } catch (Exception e) { // 异常的时候，回滚事物 sqlsession.rollback();
            e.printStackTrace();
        } finally {
            sqlsession.close();
            sc.close();
        }
    }

    @org.junit.Test
    public void show3() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("请输入删除的序号:");
            int id = sc.nextInt();
            int flag = bizdao.delInfoById(id);
            sqlsession.commit();
            System.out.println("结果是" + flag);
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        } finally {
            sqlsession.close();
            sc.close();
        }
    }

    @org.junit.Test
    public void show4() {
        try {
            List<Stu> list = bizdao.getAllStu();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getSid() + "\t" + list.get(i).getSname() + "\t" + list.get(i).getSage()
                        + "\t" + list.get(i).getGrade().getGname());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }

    }

    // public void show5() {
    // Scanner sc = new Scanner(System.in);
    // try {
    // System.out.println("请输入年级编号：");
    // int id = sc.nextInt();
    // Set<Stu> set = bizdao.getAllStuByGradeId(id);
    // System.out.println(set.size());
    // for (Stu stu : set) {
    // System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t" +
    // stu.getGrade().getStu().size());
    // }
    // } catch (Exception e) {
    // // TODO: handle exception
    // e.printStackTrace();
    // } finally {
    // sqlsession.close();
    // sc.close();
    // }
    //
    // }

    public void show6() {
        try {
            List<Grade> list = bizdao.getAllGradeByOne();
            for (int i = 0; i < list.size(); i++) {
                Grade grade = list.get(i);
                Set<Stu> set = grade.getStuu();
                for (Stu stu : set) {
                    System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t" + stu.getSage() + "\t"
                            + stu.getGrade().getGname());
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
