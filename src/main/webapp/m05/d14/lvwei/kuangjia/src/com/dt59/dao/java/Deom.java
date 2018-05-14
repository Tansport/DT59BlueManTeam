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

import org.junit.Test;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

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
}
