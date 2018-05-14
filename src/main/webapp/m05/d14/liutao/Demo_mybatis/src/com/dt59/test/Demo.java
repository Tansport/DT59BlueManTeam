/**
 * Project Name:Demo_mybatis
 * File Name:Demo.java
 * Package Name:com.dt59.test
 * Date:2018年5月14日下午2:11:12
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.dt59.dao.impl.BizDaoImpl;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午2:11:12 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Demo {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BizDaoImpl bdi = new BizDaoImpl();
        /*
         * List<Stu> list = bdi.getAllinfo(); for (Stu stu : list) {
         * System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t" +
         * stu.getSage()); }
         */
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

}
