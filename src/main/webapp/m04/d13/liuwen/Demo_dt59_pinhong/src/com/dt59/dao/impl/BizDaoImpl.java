/**
 * Project Name:Demo_dt59_pinhong
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月12日下午7:04:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:04:25 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<News> getAllNews() {

        // Auto-generated method stub
        List<News> listnews = new ArrayList<News>();
        try {
            String sql = " SELECT * FROM `news`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNid(rs.getInt(1));
                news.setNtitle(rs.getString(2));
                news.setNcontent(rs.getString(3));
                news.setNdate(rs.getDate(4));
                listnews.add(news);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> listproduct = new ArrayList<Product>();
        try {
            String sql = " SELECT * FROM `product`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setPid(rs.getInt(1));
                product.setPname(rs.getString(2));
                product.setPbrand(rs.getString(3));
                product.setPmodel(rs.getString(4));
                product.setPprice(rs.getDouble(5));
                product.setPpicture(rs.getString(6));
                product.setPdes(rs.getString(7));
                listproduct.add(product);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listproduct;
    }

    @Override
    public List<User> getAllUsers() {
        // Auto-generated method stub
        List<User> listusers = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM `user`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));
                user.setUpic(rs.getString(5));
                listusers.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listusers;
    }

    @Override
    public boolean validateUser(User user) {
        // Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM `user` WHERE `uname` = ? AND `upwd` = ?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public String getUstatus(User user) {
        String ustatus = "";
        // Auto-generated method stub
        try {
            String sql = "SELECT `ustatus` FROM `user` WHERE `uname` = ?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            rs = pst.executeQuery();
            while (rs.next()) {
                ustatus = rs.getString(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return ustatus;
    }

    @Override
    public List<Product> getAllProductsByPage(Page page) {
        List<Product> listproduct = new ArrayList<Product>();
        try {
            String sql = " SELECT * FROM `product` limit ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpage() - 1) * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setPid(rs.getInt(1));
                product.setPname(rs.getString(2));
                product.setPbrand(rs.getString(3));
                product.setPmodel(rs.getString(4));
                product.setPprice(rs.getDouble(5));
                product.setPpicture(rs.getString(6));
                product.setPdes(rs.getString(7));
                listproduct.add(product);
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
