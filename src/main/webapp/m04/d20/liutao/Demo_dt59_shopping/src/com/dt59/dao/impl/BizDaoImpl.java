/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月19日下午12:22:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.Shopping;
import com.dt59.entity.User;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:22:58 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<Shopping> getAllShopping() {
        List<Shopping> list = new ArrayList<Shopping>();
        try {
            String sql = "SELECT * FROM shangping";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Shopping sp = new Shopping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getString(3));
                sp.setSpdesc(rs.getString(4));
                list.add(sp);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        // Auto-generated method stub
        return list;
    }

    @Override
    public boolean getAllUser(User User) {
        boolean flag = false;
        try {
            String sql = "SELECT * FROM USER  WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, User.getUname());
            pst.setString(2, User.getUpwd());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }

        return flag;
    }

    @Override
    public Shopping getAllbyId(int sid) {
        Shopping sp = null;
        try {
            String sql = "SELECT * FROM shangping WHERE spid=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, sid);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp = new Shopping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getString(3));
                sp.setSpdesc(rs.getString(4));

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        // Auto-generated method stub
        return sp;
    }

}
