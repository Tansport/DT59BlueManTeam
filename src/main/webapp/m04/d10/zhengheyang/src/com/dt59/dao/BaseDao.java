package com.dt59.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {
    protected Connection con = null;// ����ͨ��

    protected PreparedStatement pst = null;// Ԥ����

    protected ResultSet rs = null;// �����

    protected CallableStatement cstate = null;// ���ô洢���̵Ľӿ�

    protected DataSource ds = null;

    /*
     * static String driver;
     * 
     * static String url;
     * 
     * static String username;
     * 
     * static String userpwd; static { init();// ���ز�ͬ�����ļ��ġ����� }
     */
    /**
     * @see ��ʼ�����ݿ����ӵ�
     */
    /*
     * public static void init() { Properties pro = new Properties();//
     * Properties�ṩ�������ļ��ķ����Ͷ�ȡ�����ļ��м��ķ��� String path =
     * "database.properties";// �����ļ���λ�� try { InputStream ist =
     * BaseDao.class.getClassLoader().getResourceAsStream(path);//
     * �������ļ������ķ�ʽ��� pro.load(ist);// ���ض����� driver =
     * pro.getProperty("driver"); url = pro.getProperty("url"); username =
     * pro.getProperty("username"); userpwd = pro.getProperty("password"); }
     * catch (Exception e) { // TODO: handle exception e.printStackTrace(); } }
     */

    // ���ӷ���
    public Connection getCon() {

        try {
            // Class.forName(driver);
            // con= DriverManager.getConnection(url, username, userpwd);
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:/comp/env/second");
            con = ds.getConnection();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    // �رյķ���
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
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
