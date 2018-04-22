/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.imp
 * Date:2018年4月19日下午4:10:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.imp;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.MingXi;
import com.dt59.entity.ShangPin;
import com.dt59.entity.User;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午4:10:36 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao{

    @Override
    public List<ShangPin> getAllShangPin() {
        List<ShangPin> listsp=new ArrayList<ShangPin>();
        try {
            String sql="SELECT * FROM shangpin";
           pst= getCon().prepareStatement(sql);
           rs=pst.executeQuery();
           while(rs.next()){
               ShangPin sp=new ShangPin();
               sp.setSpid(rs.getInt(1));
               sp.setSpname(rs.getString(2));
               sp.setSpprice(rs.getFloat(3));
               sp.setSpdesc(rs.getString(4));
               listsp.add(sp);
           }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return listsp;
    }

    @Override
    public boolean validateUser(User user) {
        boolean flag=false;
        try {
            String sql="SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst=getCon().prepareStatement(sql);
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
        //  Auto-generated method stub
        return flag;
    }

    @Override
    public ShangPin getShangpinById(int id) {
        ShangPin sp=null;
        try{
            String sql="SELECT * FROM shangpin WHERE spid=?";
        pst= getCon().prepareStatement(sql);
        pst.setInt(1, id);
        rs=pst.executeQuery();
        while(rs.next()){
           sp=new ShangPin();
            sp.setSpid(rs.getInt(1));
            sp.setSpname(rs.getString(2));
            sp.setSpprice(rs.getFloat(3));
            sp.setSpdesc(rs.getString(4));
        }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        //  Auto-generated method stub
        return sp;
    }

    @Override
    public List<MingXi> getAllMingXi() {
        List<MingXi> listmin=new ArrayList<MingXi>();
        //  Auto-generated method stub
        try {
            String sql="INSERT INTO mingix VALUES(?,?,?,?,?,?)";
           pst= getCon().prepareStatement(sql);
          rs= pst.executeQuery();
          while(rs.next()){
              MingXi min=new MingXi();
              min.setSpid(rs.getInt(1));
              min.setSpname(rs.getString(2));
              min.setSpnum(rs.getInt(3));
              min.setSpprice(rs.getFloat(4));
              min.setSpdesc(rs.getString(5));
              min.setSpsum(rs.getInt(6));
              listmin.add(min);
          }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        
        return listmin;
    }

}

