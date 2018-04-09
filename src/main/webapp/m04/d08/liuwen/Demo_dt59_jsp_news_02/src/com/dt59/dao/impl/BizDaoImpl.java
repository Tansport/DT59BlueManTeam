package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public boolean validateUser(UserInfo user) {
        // TODO Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

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
    public List<NewsInfo> getNews() {
        // TODO Auto-generated method stub
        List<NewsInfo> listnews = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo info = new NewsInfo();
                info.setNewsid(rs.getInt(1));
                info.setTypeid(rs.getInt(2));
                info.setNewstitle(rs.getString(3));
                info.setNewsauthor(rs.getString(4));
                info.setNewssummary(rs.getString(5));
                info.setNewscontent(rs.getString(6));
                info.setNewspic(rs.getString(7));
                listnews.add(info);
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

    @Override
    public List<CommentInfo> getComments() {

        // Auto-generated method stub
        List<CommentInfo> listcomment = new ArrayList<CommentInfo>();
        try {
            String sql = "SELECT * FROM `comment_info`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                CommentInfo commentinfo = new CommentInfo();
                commentinfo.setCommentid(rs.getInt(1));
                commentinfo.setUsername(rs.getString(2));
                commentinfo.setIp(rs.getString(3));
                commentinfo.setContent(rs.getString(4));
                commentinfo.setNewsid(rs.getInt(5));
                commentinfo.setFbtime(rs.getDate(6));
                listcomment.add(commentinfo);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listcomment;
    }

}
