

package com.xin.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;



/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午3:54:51 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con=null;//连接通道
    protected PreparedStatement pst=null;//预编译
    protected ResultSet rs=null;//结果集
    static String driver;
    static String url;
    static String username;
    static String userpwd;
    static{
        init();
    }
    
    
    
    public static void init(){
        Properties pro=new Properties();//properties提供加属性文件的方法和读取属性文件中键的方法
        String path="database.properties";
        try {
            InputStream ist= BaseDao.class.getClassLoader().getResourceAsStream(path);//把文件以流的方式输出
            pro.load(ist);//加载二进流
            driver=pro.getProperty("driver");
            url=pro.getProperty("url");
            username=pro.getProperty("username");
            userpwd=pro.getProperty("password");
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        
    }
    //连接方法
    public Connection getCon(){
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url, username, userpwd);
        } catch (Exception e) {
            // TODO: handle exception
        e.printStackTrace();
        }
        return con;
    }
    //关闭的方法
    public void close(Connection con,PreparedStatement pst,ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(pst!=null){
                pst.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}

