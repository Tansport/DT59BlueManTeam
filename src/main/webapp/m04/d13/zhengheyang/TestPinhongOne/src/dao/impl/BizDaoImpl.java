/**
 * Project Name:TestPinhongOne
 * File Name:BizDaoImpl.java
 * Package Name:dao.impl
 * Date:Apr 15, 20183:03:37 PM
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.BizDao;
import entity.News;

/**
 * Description: <br/>
 * Date: Apr 15, 2018 3:03:37 PM <br/>
 * 
 * @author zhengheyang
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    public List<News> getAllNews() {
        List<News> listnews = new ArrayList<News>();
        try {
            String sql = "SELECT * FALSE news";
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
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

}
