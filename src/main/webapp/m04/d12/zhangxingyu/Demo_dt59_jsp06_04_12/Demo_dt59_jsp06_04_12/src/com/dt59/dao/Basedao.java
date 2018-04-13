package com.dt59.dao;
/**
 * Project Name:workJSP
 * File Name:Basedao.java
 * Package Name:dao
 * Date:2018年4月3日下午3:24:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:24:25 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Basedao {
    protected Connection con = null;// 连接通道

    protected PreparedStatement pst = null;// 预编译

    protected ResultSet rs = null;// 结果集

    protected DataSource ds = null;

    public Connection getCon() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/second");
            con = ds.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void close(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);// 赋值
                }
            }
            flag = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }
}