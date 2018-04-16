/**
 * Project Name:Demo_dt59_jsp06_04_12
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月12日下午7:00:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.BizDao;
import entity.Message;
import entity.News;
import entity.Page;
import entity.Product;
import entity.User;
import entity.revert;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:00:25 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BizDaoImpl extends Basedao implements BizDao {
    @Override
    public List<News> getAllNews() {
        List<News> listnews = new ArrayList<News>();
        try {
            String sql = "SELECT * FROM news";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                News ns = new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setNdate(rs.getDate(4));
                listnews.add(ns);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

    public List<Product> getALLProduct() {
        List<Product> listpro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdesc(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return listpro;
    }

    @Override
    public boolean validateUser(User user) {

        // Auto-generated method stub
        boolean flag = false;
        try {

            String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
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
        }
        return flag;
    }

    public String AllUser(User user) {
        String str = "";
        try {
            String sql = "SELECT ustatus FROM USER WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
            rs = pst.executeQuery();
            while (rs.next()) {
                str = rs.getString(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return str;
    }

    /**
     *
     * @see dao.BizDao#getAllUser()
     */
    public List<User> getAllUser() {
        List<User> listuser = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM USER";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));
                user.setUpic(rs.getString(5));
                listuser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return listuser;
    }

    public List<Page> sum() {
        List<Page> sum = new ArrayList<Page>();
        String sql = "SELECT COUNT(1) FROM product";
        try {
            pst = getCon().prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                Page page = new Page();
                page.setSumsize(rs.getInt(1));
                sum.add(page);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return sum;
    }

    public List<Product> newslist(Page page) {
        List<Product> list = new ArrayList<Product>();
        String sql = "SELECT * FROM product LIMIT ?,?";
        try {
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
                pro.setPdesc(rs.getString(7));
                list.add(pro);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    public List<Message> getmessage() {
        List<Message> listmessage = new ArrayList<Message>();
        try {
            String sql = "SELECT * FROM message";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Message mess = new Message();
                mess.setMid(rs.getInt(1));
                mess.setMtitle(rs.getString(2));
                mess.setMcontent(rs.getString(3));
                mess.setMname(rs.getString(4));
                mess.setMdate(rs.getDate(5));
                mess.setRcount(rs.getInt(6));
                listmessage.add(mess);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return listmessage;
    }

    public List<revert> getrevert() {
        List<revert> listrev = new ArrayList<revert>();
        try {
            String sql = "SELECT * FROM revert";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                revert rev = new revert();
                rev.setRid(rs.getInt(1));
                rev.setMid(rs.getInt(2));
                rev.setRcontent(rs.getString(3));
                rev.setRname(rs.getString(4));
                rev.setRdate(rs.getDate(5));
                listrev.add(rev);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return listrev;
    }

    public int setrevert(int mid, String rcontent, String rname) {
        int flage = 0;
        try {
            String sql = "INSERT INTO revert(`mid`,rcontent,rname,rdate ) VALUES(?,?,?,NOW())";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, mid);
            pst.setString(2, rcontent);
            pst.setString(3, rname);
            flage = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return flage;
    }

}
