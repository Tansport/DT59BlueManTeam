/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.imp
 * Date:2018年4月12日下午7:05:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:05:52 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {
   
    @Override
    public List<News> getAllNews() {
        List<News> listnews=new ArrayList<News>();
        //  Auto-generated method stub
        try {
            String sql="SELECT * FROM news";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                News ns=new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setNdate(rs.getDate(4));
                listnews.add(ns);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listnews;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> listpro=new ArrayList<Product>();
        //  Auto-generated method stub
        try {
            String sql="SELECT * FROM product";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                Product pro=new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listpro;
    }

    @Override
    public boolean validateUser(User user) {
        
        boolean flag=false;
        try {
            String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst= getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
            rs=pst.executeQuery();
            while(rs.next()){
                flag=true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return flag;
    }

    @Override
    public List<User> getAllUser() {
        List<User> listuser=new ArrayList<User>();
        try {
            String sql="SELECT * FROM USER";
            pst= getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));
                user.setUpic(rs.getString(5));
                listuser.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return listuser;
    }

    @Override
    public String validate(User user) {
        String str="";
        try {
            
            String sql="SELECT ustatus FROM USER WHERE uname=? AND upwd=?";
            pst= getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
            rs=pst.executeQuery();
            while(rs.next()){
                str=rs.getString(1);
            }  
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        
        //  Auto-generated method stub
        return str;
    }
    @Override
    public int getSumCount(Page page) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(1) FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        // Auto-generated method stub
        return count;
    }
    @Override
    public List<Product> getLimitPage(Page page) {
        List<Product> listproduct = new ArrayList<Product>();
        try {
            String sql = "select * from product limit ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpage() - 1) * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdes(rs.getString(7));
                listproduct.add(pro);

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        // Auto-generated method stub
        return listproduct;
    }
    
}

