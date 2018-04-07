/**
 * Project Name:TestJDBC
 * File Name:JdbcUtils.java
 * Package Name:cn.java.utils
 * Date:Mar 28, 20183:52:28 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package cn.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import cn.java.JDBC.Jdbc;

/**
 * Description: 操作JDBC的工具类<br/>
 * Date: Mar 28, 2018 3:52:28 PM <br/>
 * 
 * @author zhengheyang
 * @version
 * @see
 */
public class JdbcUtils {
    private static String driver;

    private static String ulr;

    private static String username;

    private static String password;
    static {
        try {
            Properties ps = new Properties();
            InputStream ins = Jdbc.class.getClassLoader().getResourceAsStream("database.properties");
            ps.load(ins);
            driver = ps.getProperty("driver");
            ulr = ps.getProperty("ulr");
            username = ps.getProperty("username");
            password = ps.getProperty("password");
            Class.forName(driver);
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    /**
     * 
     * Description:获取数据库链接 <br/>
     *
     * @author zhengheyang
     * @return
     * @throws Exception
     */
    public static Connection getConnction() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/house", "root", "root");
    }
}
