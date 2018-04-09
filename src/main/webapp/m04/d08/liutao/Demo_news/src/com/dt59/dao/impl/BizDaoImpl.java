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
    public boolean validateUser(UserInfo ui) {

        boolean flag = false;
        try {
            String sql = "SELECT *FROM user_info WHERE username=? AND PASSWORD=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, ui.getName());
            pst.setString(2, ui.getPsw());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);

        }
        return flag;
    }

    /**
     *
     * @see com.dt59.dao.BizDao#addTitle()
     */
    @Override
    public List<NewsInfo> addTitle() {
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo ui = new NewsInfo();
                ui.setNews_id(rs.getInt(1));
                ui.setType_id(rs.getInt(2));
                ui.setNews_title(rs.getString(3));
                ui.setNews_author(rs.getString(4));
                ui.setNews_summary(rs.getString(5));
                ui.setNews_content(rs.getString(6));
                ui.setNews_pic(rs.getString(7));
                list.add(ui);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public int delNewsInfoById(int id) {
        int result = 0;
        try {
            String sql = "DELETE FROM news_info WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        // Auto-generated method stub
        return result;
    }

    @Override
    public List<CommentInfo> showInfo() {
        List<CommentInfo> listInfo = new ArrayList<CommentInfo>();
        try {
            String sql = "SELECT * FROM comment_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {// 装箱
                CommentInfo ci = new CommentInfo();
                ci.setComment_id(rs.getInt(1));
                ci.setUsername(rs.getString(2));
                ci.setIp(rs.getString(3));
                ci.setContent(rs.getString(4));
                ci.setNews_id(rs.getInt(5));
                ci.setFbtime(rs.getDate(6));
                listInfo.add(ci);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }

        // Auto-generated method stub
        return listInfo;
    }

    @Override
    public int modification(NewsInfo ni) {
        int result = 0;
        try {
            String sql = "UPDATE news_info SET news_title=?,news_author=? WHERE news_id=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, ni.getNews_title());
            pst.setString(2, ni.getNews_author());
            pst.setInt(3, ni.getNews_id());
            result = pst.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return result;
    }
}
