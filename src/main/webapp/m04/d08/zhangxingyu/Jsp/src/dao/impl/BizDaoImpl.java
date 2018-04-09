package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.BizDao;
import entity.NewsInfo;
import entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

    public boolean validateUser(UserInfo user) {
        // TODO Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
            pst = getCon().prepareStatement(sql);
            // ¸³Öµ
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            // Ö´ÐÐ
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

    public List<NewsInfo> getNews() {
        // TODO Auto-generated method stub
        List<NewsInfo> listnews = new ArrayList<NewsInfo>();
        try {
            String sql = "SELECT * FROM news_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo info = new NewsInfo();
                info.setNewsId(rs.getInt(1));
                info.setTypeId(rs.getInt(2));
                info.setNewsTitle(rs.getString(3));
                info.setNewsAuthor(rs.getString(4));
                info.setNewsSummary(rs.getString(5));
                info.setNewsContent(rs.getString(6));
                info.setNewsPic(rs.getString(7));
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
    public boolean denglu(UserInfo user) {

        // Auto-generated method stub
        return false;
    }

    @Override
    public List<NewsInfo> all() {

        // Auto-generated method stub
        return null;
    }

}
