/**
 * Project Name:workspace1
 * File Name:Test1.java
 * Package Name:lession180326
 * Date:2018��3��27������3:47:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d27.lvwei;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018��3��27�� ����3:47:16 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Test1 {

    public static void main(String[] args) {

        Test1 tt = new Test1();
        List<province> list = tt.getAll();
        for (province ff : list) {
            System.out.println(ff.getCid() + "\t" + ff.getCname() + "\t" + ff.getPname());
        }

    }

    Connection con = null;

    PreparedStatement pst = null;

    ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/mydata";

    public Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public List<province> getAll() {
        List<province> list = new ArrayList<province>();
        try {
            String sql = "SELECT b.`cid`,b.`cname`,a.`pname` FROM province a INNER JOIN city b ON a.`pid`=b.`pid`";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                province ff = new province();
                ff.setCid(rs.getInt(1));
                ff.setCname(rs.getString(2));
                ff.setPname(rs.getString(3));
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

    public void close(Connection con, PreparedStatement pst, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
