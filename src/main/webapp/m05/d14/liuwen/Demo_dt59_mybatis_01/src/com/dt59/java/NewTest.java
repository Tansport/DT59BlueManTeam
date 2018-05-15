/**
 * Project Name:Demo_dt59_mybatis_01
 * File Name:NewTest.java
 * Package Name:com.dt59.java
 * Date:2018年5月14日下午11:29:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午11:29:47 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class NewTest {
    BizDaoImpl bdi = new BizDaoImpl();

    @Test
    public void show1() {
        List<HashMap<String, Object>> list = bdi.getAllStu();

        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> allkey = map.keySet();
            for (String key : allkey) {
                System.out.print(map.get(key) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void show2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入编号:");
        int id = sc.nextInt();
        Stu stu = bdi.getStuById(id);
        System.out.println(stu.getSid() + "\t" + stu.getSname());
        sc.close();
    }
}
