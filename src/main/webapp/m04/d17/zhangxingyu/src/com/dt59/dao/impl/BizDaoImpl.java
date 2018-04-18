package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.Revert;
import com.dt59.entity.User;

public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    public List<News> getAllNews() {
        // TODO Auto-generated method stub
        List<News> listnews = new ArrayList<News>();
        try {
            String sql = "SELECT * FROM news";
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
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listnews;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> listpro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdesc(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listpro;
    }

    @Override
    public boolean validateUser(User user) {
        // TODO Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, user.getUname());
            pst.setString(2, user.getUpwd());
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
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        List<User> listUser = new ArrayList<User>();
        try {
            String sql = "SELECT * FROM USER";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setUpwd(rs.getString(3));
                user.setUstatus(rs.getString(4));
                user.setUpic(rs.getString(5));
                listUser.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listUser;
    }

    @Override
    public String getUserRoleByName(String name, String pwd) {
        // TODO Auto-generated method stub
        String role = "";
        try {
            String sql = "SELECT t.`ustatus` FROM USER t WHERE t.`uname`=? AND t.`upwd`=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pwd);
            rs = pst.executeQuery();
            while (rs.next()) {
                role = rs.getString(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return role;
    }

    @Override
    public List<Product> getAllProductByPage(Page page) {
        // TODO Auto-generated method stub
        List<Product> listpro = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product LIMIT ?,?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, (page.getCurrentpage() - 1) * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs = pst.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPid(rs.getInt(1));
                pro.setPname(rs.getString(2));
                pro.setPbrand(rs.getString(3));
                pro.setPmodel(rs.getString(4));
                pro.setPprice(rs.getDouble(5));
                pro.setPpicture(rs.getString(6));
                pro.setPdesc(rs.getString(7));
                listpro.add(pro);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listpro;
    }

    @Override
    public int getProductNumber() {
        // TODO Auto-generated method stub
        int count = 0;
        try {
            String sql = "SELECT COUNT(1) FROM product";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return count;
    }

    @Override
    public List<Message> getAllMessage() {
        // TODO Auto-generated method stub
        List<Message> listmess = new ArrayList<Message>();
        try {
            String sql = "SELECT * FROM message";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Message mess = new Message();
                mess.setMid(rs.getInt(1));
                mess.setMtitle(rs.getString(2));
                mess.setMcontent(rs.getString(3));
                mess.setMname(rs.getString(4));
                mess.setMdate(rs.getDate(5));
                mess.setRcount(rs.getInt(6));
                listmess.add(mess);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listmess;
    }

    @Override
    public Message getMessageById(int id) {
        // TODO Auto-generated method stub
        Message mess = null;
        try {
            String sql = "SELECT * FROM message WHERE MID=?";
            pst = getCon().prepareStatement(sql);
            // ¸³Öµ
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                mess = new Message();
                mess.setMid(rs.getInt(1));
                mess.setMtitle(rs.getString(2));
                mess.setMcontent(rs.getString(3));
                mess.setMname(rs.getString(4));
                mess.setMdate(rs.getDate(5));
                mess.setRcount(rs.getInt(6));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return mess;
    }

    @Override
    public List<Revert> getAllRevert() {
        // TODO Auto-generated method stub
        List<Revert> listrev = new ArrayList<Revert>();
        try {
            String sql = "SELECT * FROM revert";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Revert rev = new Revert();
                rev.setRid(rs.getInt(1));
                rev.setMid(rs.getInt(2));
                rev.setRcontent(rs.getString(3));
                rev.setRname(rs.getString(4));
                rev.setRdate(rs.getDate(5));
                listrev.add(rev);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return listrev;
    }

    @Override
    public int setrevert(int mid, String rcontent, String rname) {
        int flage = 0;
        try {
            String sql = "INSERT INTO revert(`mid`,rcontent,rname,rdate ) VALUES(?,?,?,NOW())";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, mid);
            pst.setString(2, rcontent);
            pst.setString(3, rname);
            flage = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return flage;
    }

    @Override
    public int updatemess(int rcount, int mid) {
        int flage = 0;
        try {
            String sql = "UPDATE  message  SET rcount=? WHERE MID=?;";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, rcount);
            pst.setInt(2, mid);
            flage = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return flage;
    }

    @Override
    public int rcount(int mid) {
        int r = 0;
        try {
            String sql = "SELECT COUNT(1) FROM revert WHERE MID=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, mid);
            rs = pst.executeQuery();
            while (rs.next()) {
                r = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return r;
    }

}
