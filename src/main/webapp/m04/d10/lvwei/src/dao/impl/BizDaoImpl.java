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
import entity.Page;
import entity.UserInfo;
import entity.comment_info;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午11:06:01 <br/>
 * 
 * @author lvwei
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
        String sql = "SELECT * FROM news_info";
        try {
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo nf = new NewsInfo();
                nf.setNewsId(rs.getInt(1));
                nf.setTypeId(rs.getInt(2));
                nf.setNewsTitle(rs.getString(3));
                nf.setNewsAuthor(rs.getString(4));
                nf.setNewsSummary(rs.getString(5));
                nf.setNewsContent(rs.getString(6));
                nf.setNewsPic(rs.getString(7));
                list.add(nf);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    public int delNewsInfoById(int id) {
        // TODO Auto-generated method stub
        int flag = 0;
        try {
            String sql = "DELETE FROM news_info WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, id);
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public int gengxin(NewsInfo nf) {
        // TODO Auto-generated method stub
        int flag = 0;
        try {
            String sql = "UPDATE news_info SET news_author=?,news_title=? WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, nf.getNewsAuthor());
            pst.setString(2, nf.getNewsTitle());
            pst.setInt(3, nf.getNewsId());
            flag = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return flag;
    }

    public List<comment_info> all1() {
        List<comment_info> list = new ArrayList<comment_info>();
        String sql = "SELECT * FROM comment_info";

        try {
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                comment_info cif = new comment_info();
                cif.setCommentid(rs.getInt(1));
                cif.setUsername(rs.getString(2));
                cif.setIp(rs.getString(3));
                cif.setContent(rs.getString(4));
                cif.setNewsid(rs.getInt(5));
                cif.setFbtime(rs.getDate(6));
                list.add(cif);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    public List<NewsInfo> newslist(Page page) {
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        String sql = "SELECT * FROM news_info LIMIT ?,?";
        try {
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpage() - 1) * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo nf = new NewsInfo();
                nf.setNewsId(rs.getInt(1));
                nf.setTypeId(rs.getInt(2));
                nf.setNewsTitle(rs.getString(3));
                nf.setNewsAuthor(rs.getString(4));
                nf.setNewsSummary(rs.getString(5));
                nf.setNewsContent(rs.getString(6));
                nf.setNewsPic(rs.getString(7));
                list.add(nf);
            }
        } catch (SQLException e) {

            // Auto-generated catch block
            e.printStackTrace();

        }
        return list;
    }

    public List<Page> sum() {
        List<Page> sum = new ArrayList<Page>();
        String sql = "SELECT COUNT(*) FROM news_info; ";
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
}
