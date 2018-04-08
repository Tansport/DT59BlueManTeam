/**
 * Project Name:workJSP
 * File Name:BizDaoImpl.java
 * Package Name:dao.impl
 * Date:2018年4月3日下午11:06:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.BizDao;
import entity.NewsInfo;
import entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午11:06:01 <br/>
 * 
 * @author zhengheyang
 * @version
 * @see
 */
public class BizDaoImpl extends Basedao implements BizDao {

    @Override
    public boolean denglu(UserInfo user) {
        boolean flag = false;
        String sql = "SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
        try {
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPwd());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    @Override
    public List<NewsInfo> all() {
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        String sql = "SELECT news_title,news_author FROM news_info";
        try {
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo nf = new NewsInfo();
                nf.setNewsTitle(rs.getString(1));
                nf.setNewsAuthor(rs.getString(2));
                list.add(nf);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }
}
