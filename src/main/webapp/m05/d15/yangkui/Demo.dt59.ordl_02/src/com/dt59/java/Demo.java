/**
 * Project Name:Demo.dt59.ordl_02
 * File Name:Demo.java
 * Package Name:com.dt59.java
 * Date:2018年5月15日上午11:29:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Grade;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionUtil;

/**
 * Description:   <br/>
 * Date:     2018年5月15日 上午11:29:34 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class Demo {
    GetSqlSessionUtil gsu= GetSqlSessionUtil.getInstance();
    SqlSessionFactory ssf= gsu.getsqlsessionfactory_();
    SqlSession sqlsession= ssf.openSession(false);
    BizDao bizdao= sqlsession.getMapper(BizDao.class);
    @Test
    public void show1(){
        List<HashMap<String, Object>> list= bizdao.getStudent();
        for(int i=0;i<list.size();i++){
            HashMap<String, Object> map= list.get(i);
            Set<String> allkey= map.keySet();
            for (String ss : allkey) {
                System.out.println(map.get(ss)+"\t");
            }
            System.out.println();
        }
    }
    @Test
    public void show2(){
        try {
            Stu stu=new Stu();
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入姓名：");
            stu.setSname(sc.next());
            System.out.println("请输入年龄：");
            stu.setSage(sc.nextInt());
            System.out.println("请输入卡号：");
            stu.setScard(sc.next());
//            System.out.println("请输入年级编号：");
//            stu.setSgid(sc.nextInt());
            int flag=bizdao.addStudent(stu);
            sqlsession.commit();
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
        
    }
    @Test
    public void show3(){
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入编号：");
            int sid=sc.nextInt();
            int flag=bizdao.delStu(sid);
            sqlsession.commit();
        } catch (Exception e) {
            // TODO: handle exception
            sqlsession.rollback();
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
        
    }
    @Test
    public void show4(){
        try {
            List<Stu> list= bizdao.getAllStu();
            for(int i=1;i<list.size();i++){
                System.out.println(list.get(i).getSid()+"\t"+list.get(i).getSname()+"\t"+list.get(i).getSage()+"\t"+list.get(i).getGrade().getGname());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
    @Test
    public void show5(){
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("请输入编号:");
            int id=sc.nextInt();
            Set<Stu> set= bizdao.getStu(id);
          for(int i=1;i<set.size();i++){
              System.out.println(set.size()+"\t");
          }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            sqlsession.close();
        }
    }
    
}

