/**
 * Project Name:study
 * File Name:BaseDao.java
 * Package Name:com.test.dao
 * Date:2018年3月28日下午4:28:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:28:43 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BaseDao {
    protected Connection conn = null;

    protected PreparedStatement ps = null;

    protected ResultSet rs = null;

    static String driver;

    static String url;

    static String username;

    static String password;
    static {
        init();
    }

    // 初始化数据库连接
    public static void init() {
        Properties pro = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");

        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

    }

    // 加载驱动，连接数据库
    public Connection getAllCon() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }

    // 控制数据
    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            ps = getAllCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }

            }
            flag = ps.executeUpdate();

        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(conn, ps, rs);
        }

        return flag;
    }

    // 关闭连接
    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();

            }
            if (ps != null) {
                ps.close();

            }
            if (conn != null) {
                conn.close();

            }
        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
