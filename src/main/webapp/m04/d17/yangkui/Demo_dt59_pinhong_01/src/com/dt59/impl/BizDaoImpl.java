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
import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.Revert;
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
    public List<Product> getAllProductByPage(Page page) {
        List<Product> listpro=new ArrayList<Product>();
       
        try {
            String sql="SELECT * FROM product LIMIT ?,?";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpage()-1)*page.getPagesize());
            pst.setInt(2, page.getPagesize());
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
        //  Auto-generated method stub
        return listpro;
    }

    @Override
    public int getProductNumber() {
        int count=0;
        try {
            String sql="SELECT COUNT(1) FROM product";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return count;
    }

    @Override
    public List<Message> getAllMessage() {
        List<Message>  listmess=new ArrayList<Message>();
        try {
            String sql="SELECT * FROM `message`";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                Message mes=new Message();
                mes.setMid(rs.getInt(1));
                mes.setMtitle(rs.getString(2));
                mes.setMcontent(rs.getString(3));
                mes.setMname(rs.getString(4));
                mes.setMdate(rs.getString(5));
                mes.setRcount(rs.getInt(6));
                listmess.add(mes);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return listmess;
    }
  
    @Override
    public List<Revert> getRevertById(int  id) {
        
        List<Revert>  listrev=new ArrayList<Revert>();
        try {
            String sql="SELECT * FROM `revert` WHERE MID=? ";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, id);
            rs=pst.executeQuery();
            while(rs.next()){
                Revert rev=new Revert();
                rev.setRid(rs.getInt(1));
                rev.setMid(rs.getInt(2));
                rev.setRcontent(rs.getString(3));
                rev.setRname(rs.getString(4));
                rev.setRtate(rs.getString(5));
                listrev.add(rev);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return listrev;
   
    }

    @Override
    public Message getMessageById(int id) {
        Message mes=null;
        try {
            String sql="SELECT * FROM `message` WHERE MID=?";
           pst= getCon().prepareStatement(sql);
           pst.setInt(1, id);
           rs= pst.executeQuery();
            while(rs.next()){
                mes=new Message();
                mes.setMid(rs.getInt(1));
                mes.setMtitle(rs.getString(2));
                mes.setMcontent(rs.getString(3));
                mes.setMname(rs.getString(4));
                mes.setMdate(rs.getString(5));
                mes.setRcount(rs.getInt(6));
                
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return mes;
    }

    @Override
    public int messageAndrevert(Revert revert) {
        int flag=0;
        try {
            String sql="INSERT INTO revert(MID,rcontent,rname,rdate) VALUE(?,?,?,NOW())";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, revert.getMid());
            pst.setString(2, revert.getRcontent());
            pst.setString(3, revert.getRname());
            flag=pst.executeUpdate();
           if(flag>0){
               String sql2="UPDATE message SET rcount=rcount+1 WHERE MID=?";
               pst=getCon().prepareStatement(sql2);
               pst.setInt(1, revert.getMid());
               flag= pst.executeUpdate();
           }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return flag;
    }

  

}

