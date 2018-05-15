/**
 * Project Name:Demo_dt59_mybatis
 * File Name:Demo.java
 * Package Name:com.dt59.java
 * Date:2018年5月15日下午2:39:20
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Stu;
import com.dt59.util.GetSqlSessionFactory;

/**
 * Description: <br/>
 * Date: 2018年5月15日 下午2:39:20 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {
        GetSqlSessionFactory gsf = GetSqlSessionFactory.getInstance();
        SqlSessionFactory ssf = gsf.getSqlSessionFactory1();

        SqlSession sqlsession = ssf.openSession();

        BizDao bizdao = sqlsession.getMapper(BizDao.class);
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
            // stu.setSgid(sc.nextInt());
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

    // Auto-generated method stub

}
