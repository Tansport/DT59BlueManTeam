/**
 * Project Name:lession1
 * File Name:BaseDao.java
 * Package Name:d03.m29.dao
 * Date:2018年3月30日下午8:46:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m29.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午8:46:58 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con = null;

    protected PreparedStatement pst = null;

    protected ResultSet rs = null;

    static String driver;

    static String url;

    static String uname;

    static String pwd;
    static {
        init();
    }

    public static void init() {
        Properties pro = new Properties();
        String path = "database.properties";

        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
            pro.load(ist);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            uname = pro.getProperty("uname");
            pwd = pro.getProperty("pwd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, uname, pwd);

        } catch (Exception e) {
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
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
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
}
