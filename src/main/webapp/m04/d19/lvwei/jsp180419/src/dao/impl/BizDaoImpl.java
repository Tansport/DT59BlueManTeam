package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import dao.BizDao;
import entity.shangping;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:00:25 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class BizDaoImpl extends Basedao implements BizDao {

    @Override
    public List<shangping> getallshangpingList() {

        // Auto-generated method stub
        List<shangping> list = new ArrayList<shangping>();
        try {
            String sql = "SELECT * FROM shangping";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                shangping sp = new shangping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getFloat(3));
                sp.setSpdesc(rs.getString(4));
                list.add(sp);
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
    public boolean User(String name, String upwd) {

        // Auto-generated method stub
        boolean flag = false;
        try {
            String sql = "SELECT * FROM USER WHERE uname=? AND upwd=?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, upwd);
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
    public shangping getshagshangpin(int spid) {

        // Auto-generated method stub
        shangping sp = null;
        try {
            String sql = "SELECT * FROM shangping WHERE spid=?";
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, spid);
            rs = pst.executeQuery();
            while (rs.next()) {
                sp = new shangping();
                sp.setSpid(rs.getInt(1));
                sp.setSpname(rs.getString(2));
                sp.setSpprice(rs.getFloat(3));
                sp.setSpdesc(rs.getString(4));
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            close(con, pst, rs);
        }
        return sp;
    }
}
