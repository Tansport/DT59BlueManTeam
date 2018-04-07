/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年3月27日下午6:57:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.dt59.en.Info;
import com.dt59.en.Infot;

/**
 * Description: <br/>
 * Date: 2018年3月27日 下午6:57:35 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    public static void main(String[] args) {
        Test tt = new Test();
        Map<Info, Infot> map = tt.getAllInfo();
        Set<Info> set = map.keySet();
        for (Info info : set) {
            logger.info(info.getCid() + "\t" + info.getCname() + "\t" + map.get(set) + "\t");
        }

    }

    Connection conn = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/mydata";

    // 加载驱动和建立连接
    public Connection getcon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            logger.error(e);
        }
        try {
            conn = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            logger.error(e);
        }

        return conn;

    }

    // 关闭连接
    public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        try {
            ps.close();
        } catch (SQLException e) {
            logger.error(e);
        }
        try {
            conn.close();
        } catch (SQLException e) {
            logger.error(e);

        }
    }

    // 传递数据并关闭
    public Map<Info, Infot> getAllInfo() {
        Map<Info, Infot> map = new HashMap<Info, Infot>();
        try {
            ps = getcon().prepareStatement(
                    "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Info info = new Info();
                Infot inf = new Infot();
                info.setCid(rs.getInt(1));
                info.setCname(rs.getString("cname"));
                inf.setPname(rs.getString("pname"));
                map.put(info, inf);

            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            close(conn, ps, rs);
        }

        return map;

    }

}
