/**
 * Project Name:Demo_jdbc_01
 * File Name:Test.java
 * Package Name:com.dt59.exer
 * Date:2018年3月27日下午2:53:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.exer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午2:53:18 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.getAllInfo();
    }

    // 先将需要连接的条件准备好
    Connection connection = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    // 连接数据库的路径
    private String url = "jdbc:mysql://localhost:3306/mydata";

    // 连接方法
    public Connection getConnection() {
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "pass");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return connection;
    }

    // 关闭方法(注意关闭的顺序)
    public void close(Connection connection, PreparedStatement pst, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // 不适用实体实现查询方法
    public void getAllInfo() {
        // List list = new ArrayList();
        try {
            String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
            pst = getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            int cid = 0;
            String cname = null;
            String pname = null;
            while (rs.next()) {
                cid = rs.getInt(1);
                cname = rs.getString(2);
                pname = rs.getString(3);
                System.out.println(cid + "\t" + cname + "\t" + pname);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            close(connection, pst, rs);
        }
    }
}
