/**
 * Project Name:Demo_dt59_mybatis_01
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年5月14日下午4:10:05
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.List;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午4:10:05 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {

        BizDaoImpl bdi = new BizDaoImpl();

        List<Stu> list = bdi.getStu();

        for (Stu student : list) {
            System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage());
        }

    }
}
