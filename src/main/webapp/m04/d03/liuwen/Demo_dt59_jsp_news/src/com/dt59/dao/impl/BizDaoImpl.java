/**
 * Project Name:Demo_dt59_jsp_news
 * File Name:BizDaoImpl.java
 * Package Name:com.dt59.dao.impl
 * Date:2018年4月3日下午3:14:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午3:14:27 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public boolean validateUser(UserInfo user) {
        // Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info a WHERE a.username=? AND a.password=?";
            pst = getCon().prepareStatement(sql);
            // 赋值
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            // 执行
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
    public List<NewsInfo> validateNewsInfo(NewsInfo newsinfo) {
        List<NewsInfo> newslist = new ArrayList<NewsInfo>();
        // Auto-generated method stub
        // boolean flag = false;
        try {
            String sql = "SELECT news_title,news_author FROM `news_info`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo ni = new NewsInfo();
                ni.setNewstitle(rs.getString(1));
                ni.setNewsauthor(rs.getString(2));
                newslist.add(ni);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return newslist;
    }

}
