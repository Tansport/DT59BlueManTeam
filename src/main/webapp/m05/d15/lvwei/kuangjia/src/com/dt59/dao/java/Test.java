/**
 * Project Name:kuangjia
 * File Name:Test.java
 * Package Name:com.dt59.dao.java
 * Date:2018年5月14日下午2:33:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.java;

import java.util.List;

import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.pojo.Stu;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午2:33:25 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {
        BizDaoImpl bdi = new BizDaoImpl();
        List<Stu> list = bdi.getStu();
        for (Stu stu : list) {
            System.out.println(stu.getId() + "\t" + stu.getName());
        }
    }
}
