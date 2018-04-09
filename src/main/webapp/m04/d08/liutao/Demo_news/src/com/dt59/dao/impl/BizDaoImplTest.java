/**
 * Project Name:Demo_news
 * File Name:BizDaoImplTest.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月8日下午8:08:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午8:08:41 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizDaoImplTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("1.setUpBeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("8.tearDownAfterClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("2-5.setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("4-7.tearDown");
    }

    @Test
    public void testValidateUser() {
        // Assert.assertTrue();
        System.out.println("6.testValidateUser");
    }

    @Test
    public void testAddTitle() {
        System.out.println("3.testAddTitle");
    }

}
