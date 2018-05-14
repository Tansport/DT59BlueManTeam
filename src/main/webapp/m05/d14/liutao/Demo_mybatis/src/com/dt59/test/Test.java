/**
 * Project Name:Demo_mybatis
 * File Name:Test.java
 * Package Name:com.dt59.test
 * Date:2018年5月14日下午1:05:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午1:05:23 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test {
    BizDaoImpl bdi = new BizDaoImpl();

    @org.junit.Test
    public void show1() {

        List<Stu> list = bdi.getAllinfo();
        for (Stu stu : list) {
            System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t" + stu.getSage());

        }

    }

    @org.junit.Test
    public void show4() {
        Stu stu = new Stu();
        Scanner sca = new Scanner(System.in);
        System.err.println("请输入整数1-8:");
        int id = sca.nextInt();
        stu = bdi.getStu(id);
        System.out.println(stu.getSid() + "\t" + stu.getSname());
        sca.close();
    }

    @org.junit.Test
    public void show5() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("name", "bbb");
        Stu stu = bdi.getStuMap(map);
        System.out.println(stu.getSgid() + "\t" + stu.getSname() + "\t" + stu.getSage());
    }

    @org.junit.Test
    public void show6() {
        Stu stu = new Stu();
        stu.setSid(1);
        stu.setSname("aaa");
        stu = bdi.getStuByEntity(stu);
        System.out.println(stu.getSgid() + "\t" + stu.getSname() + "\t" + stu.getSage());
    }

    @org.junit.Test
    public void show2() {
        List<HashMap<String, Object>> list = bdi.getAll();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> set = map.keySet();
            for (String stt : set) {
                System.out.print(map + "\t" + map.get(stt) + "\t");
            }
            System.out.println();
        }

    }

    @org.junit.Test
    public void show3() {// 多表年级人数
        List<HashMap<String, Object>> list = bdi.getLike();
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> set = map.keySet();
            for (String stt : set) {
                System.out.print(map + "\t" + map.get(stt) + "\t");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void show7() {
        Stu stu = new Stu();
        stu.setSid(12);
        stu.setSname("李四");
        stu.setSage(22);
        stu.setScard(88);
        stu.setSgid(3);
        boolean flag = bdi.getInsert(stu);
        System.out.println(flag);

    }

    public void show8() {

        Scanner scan = new Scanner(System.in);
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        System.out.println("请输入需要查询的内容：");
        String name = scan.next();
        list = bdi.getLikeNum(name);
        for (int i = 0; i < list.size(); i++) {
            HashMap<String, Object> map = list.get(i);
            Set<String> set = map.keySet();
            for (String string : set) {
                System.out.print(map + "\t" + map.get(string));
            }
            System.out.println();

        }

    }
}
