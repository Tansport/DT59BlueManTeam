/**
 * Project Name:study
 * File Name:BaseDao.java
 * Package Name:com.test.dao
 * Date:2018年3月28日下午10:25:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午10:25:11 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class BaseDao {
    protected Connection conn=null;
    protected PreparedStatement ps=null;
    protected ResultSet rs =null;
   private static String driver;
   private static String url;
   private static String username;
   private static String password;
    
    static{
        init();
    }
    
    //初始化数据库连接
    public static void init(){
        Properties pro=new Properties();       
        InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            pro.load(is);//加载流
            driver=pro.getProperty("driver");
            url= pro.getProperty("url");
            username=pro.getProperty("username");
            password=pro.getProperty("password");
            
        } catch (IOException e) {

            e.printStackTrace();
            
        }
        
    }
    //加载和链接
    public Connection getAllCon(){
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();            
        }    
        return conn;
    
    }
    //控制方法
    public int controlDml(String sql,Object[] obj){
        int flag=0;
        try {
            ps=getAllCon().prepareStatement(sql);
            if(obj!=null){
                for(int i =0;i<obj.length;i++){
                    ps.setObject(i+1, obj[i]);
                    
                }
            }
           flag= ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
         return flag;
    }
    
    
    //关闭连接
    public void close(Connection conn,PreparedStatement ps,ResultSet rs){
        try {
            if(rs!=null){
                rs.close();  
            }
          
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        try {
            if(ps!=null){
                ps.close();
            }
           
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        try {
            if(conn!=null){
                conn.close(); 
            }
            
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
    }
    
    
    

}

