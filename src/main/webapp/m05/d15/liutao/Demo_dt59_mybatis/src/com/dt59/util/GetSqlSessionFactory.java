/**
 * Project Name:Demo_dt59_mybatis
 * File Name:GetSqlSessionFactory.java
 * Package Name:com.dt59.util
 * Date:2018年5月14日下午2:27:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Description: <br/>
 * Date: 2018年5月14日 下午2:27:49 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class GetSqlSessionFactory {
    static SqlSessionFactory ssfa = null;

    private static GetSqlSessionFactory ssf = null;

    public GetSqlSessionFactory() {
    }

    public static GetSqlSessionFactory getInstance() {
        if (ssf == null) {
            ssf = new GetSqlSessionFactory();
        }
        return ssf;
    }

    public static SqlSessionFactory getSqlSessionFactory1() {
        if (ssfa == null) {
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                ssfa = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }

        }

        return ssfa;
    }

}
