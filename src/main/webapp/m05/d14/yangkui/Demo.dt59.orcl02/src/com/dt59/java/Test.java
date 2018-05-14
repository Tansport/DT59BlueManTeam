/**
 * Project Name:Demo.dt59.orcl02
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年5月14日下午2:59:17
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;



import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



import java.util.Set;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description:   <br/>
 * Date:     2018年5月14日 下午2:59:17 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class Test {
    BizDaoImpl bdi=new BizDaoImpl();
    Scanner sc=new Scanner(System.in);//扫描仪
    @org.junit.Test
    public void show1(){
        List<Stu> stu= bdi.getStu();
        for (Stu stu2 : stu) {
            System.out.println(stu2.getSid()+"\t"+stu2.getSname());
        }
    }
    @org.junit.Test
    public void show2(){
        List<HashMap<String, Object>> list= bdi.getAllStu();
        for(int i=0;i<list.size();i++){
            HashMap<String, Object> map= list.get(i);
            Set<String> allkey= map.keySet();
            for (String tt : allkey) {
                System.out.print(map.get(tt)+"\t");
            }
            System.out.println();
        }
    }
    @org.junit.Test
    public void show3(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入查询的关键字：");
        String name=sc.next();
        List<HashMap<String, Object>> list= bdi.getAllStuByLike(name);
        for(int i=0;i<list.size();i++){
            HashMap<String, Object> map= list.get(i);
            Set<String> allkey= map.keySet();
            for (String tt : allkey) {
                System.out.print(map.get(tt)+"\t");
            }
            System.out.println();
        }
        
    }
}

