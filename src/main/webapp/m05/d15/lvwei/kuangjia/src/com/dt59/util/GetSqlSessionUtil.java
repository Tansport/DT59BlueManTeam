/**
 * Project Name:kuangjia
 * File Name:GetSqlSessionUtil.java
 * Package Name:com.dt59.utif
 * Date:2018年5月14日上午11:32:45
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
 * Date: 2018年5月14日 上午11:32:45 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class GetSqlSessionUtil {
    static SqlSessionFactory ssf = null;// 接口

    public static GetSqlSessionUtil gsu = null;

    private GetSqlSessionUtil() {
    }

    public static GetSqlSessionUtil getInstance() {
        if (gsu == null) {
            gsu = new GetSqlSessionUtil();
        }
        return gsu;
    }

    public static SqlSessionFactory getsqlsessionfactory_() {
        if (ssf == null) {
            // 构建
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                ssf = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }

        }
        return ssf;
    }
}
