package com.dt59.dao;
/**
 * Project Name:workJSP
 * File Name:Basedao.java
 * Package Name:dao
 * Date:2018��4��3������3:24:25
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
 * Date: 2018��4��3�� ����3:24:25 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Basedao {
    protected Connection con = null;// ����ͨ��

    protected PreparedStatement pst = null;// Ԥ����

    protected ResultSet rs = null;// �����

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
                    pst.setObject(i + 1, obj[i]);// ��ֵ
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