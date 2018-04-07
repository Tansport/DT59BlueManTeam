package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.Info;
import com.dt59.entity.Info2;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<Info> getAllInfo() {
        // TODO Auto-generated method stub
        List<Info> list = new ArrayList<Info>();
        try {
            String sql = "SELECT * FROM info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Info ff = new Info();
                ff.setId(rs.getInt(1));
                ff.setName(rs.getString(2));
                ff.setAge(rs.getInt(3));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public int updateInfo(Object t) {// t:����һ��Infoʵ����
        //
        int flag = 0;
        try {
            String sql = "UPDATE info SET NAME=?,age=? WHERE id=?";
            Object[] obj = new Object[3];
            if (t instanceof Info) {
                Info ff = (Info) t;// ����ת��
                obj[0] = ff.getName();
                obj[1] = ff.getAge();
                obj[2] = ff.getId();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteInfo(int id) {
        // TODO Auto-generated method stub
        int flag = 0;
        try {
            String sql = "DELETE FROM info WHERE id=?";
            Object[] obj = new Object[1];
            obj[0] = id;
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int saveInfo2(Object t) {// t:Info2 ʵ����
        // TODO Auto-generated method stub
        int flag = 0;
        try {
            String sql = "INSERT INTO info2(NAME,birthday) VALUES(?,?)";
            Object[] obj = new Object[2];
            if (t instanceof Info2) {
                Info2 ff = (Info2) t;
                obj[0] = ff.getName();
                obj[1] = ff.getBirthday();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean yanzheng(UserInfo ui) {
        boolean flag = false;
        String sql = "SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
        try {
            pst = getCon().prepareStatement(sql);
            pst.setString(1, ui.getName());
            pst.setString(2, ui.getPsw());
            rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            close(con, pst, rs);
        }

        return flag;
    }

    @Override
    public List addTitle() {
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        String sql = "SELECT news_title,news_author FROM news_info";
        try {
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                NewsInfo ni = new NewsInfo();
                ni.setTitle(rs.getString(1));
                ni.setName(rs.getString(2));
                list.add(ni);
            }
        } catch (Exception e) {

            // Auto-generated catch block
            e.printStackTrace();

        }

        return list;
    }

}
