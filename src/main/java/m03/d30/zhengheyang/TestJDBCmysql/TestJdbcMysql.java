package TestJDBCmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.java.entity.User;
import cn.java.utils.JdbcUtils;

public class TestJdbcMysql {
    public static void main(String[] args) throws Exception {
        TestJdbcMysql tl = new TestJdbcMysql();
        tl.selectByIdTest();

    }

    /**
     * 插入SQL语句;
     * 
     * @throws Exception
     */

    public void insert() throws Exception {
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "insert into sys_user(uid,uname,UPASSWORD)values(14,'pwa',null)";
        Statement st = conn.createStatement();
        int result = st.executeUpdate(sql);
        if (result >= 1) {
            System.out.println("插入数据成功");
        } else {
            System.out.println("插入数据失败");
        }
        // 关闭连接;
        conn.close();
    }

    /**
     * 修改mysql;
     * 
     * @throws Exception
     */

    public void updata() throws Exception {
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "update sys_user set uname='kkk' where uid=16";
        Statement st = conn.createStatement();
        int result = st.executeUpdate(sql);
        if (result >= 1) {
            System.out.println("修改数据成功");
        } else {
            System.out.println("修改数据失败");
        }
        // 关闭连接;
        conn.close();
    }

    /**
     * 删除sql字段;
     * 
     * @throws Exception
     */

    public void delete() throws Exception {
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "delete from sys_user where uid > 13";
        Statement st = conn.createStatement();
        int result = st.executeUpdate(sql);
        if (result >= 1) {
            System.out.println("删除数据成功");
        } else {
            System.out.println("删除数据失败");
        }
        // 关闭连接;
        conn.close();
    }

    /**
     * 查询sql(多表查询);
     * 
     * @throws Exception
     */

    public void selectById() throws Exception {
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "select uid,uname,upassword,htid,htname from sys_user a inner join hos_type b on a.`uid`=b.`htid`";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int uid = rs.getInt("uid");
            String uname = rs.getString("uname");
            String upassword = rs.getString("upassword");
            int htid = rs.getInt("HTID");
            String htname = rs.getString("HTName");
            // 打印输出;
            System.out.println(
                    "uid=" + uid + " uname=" + uname + " upassword=" + upassword + " htid" + htid + " HTName" + htname);
        }
        // 关闭连接;
        conn.close();
    }

    /**
     * 通过实体类封装查询数据(方法一);
     * 
     * @throws Exception
     */

    public void selectByIdTest() throws Exception {

        // 连接数据库;
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "select * from sys_user";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            Integer uid = rs.getInt("uid");
            String uname = rs.getString("uname");
            String upassword = rs.getString("upassword");
            User user = new User(uid, uname, upassword);
            list.add(user);
        }
        for (User user : list) {
            System.out.println(user);
        }
        // 关闭连接;
        conn.close();
    }

    /**
     * 添加mysql数据;
     * 
     * @throws Exception
     */

    public void inser() throws Exception {
        Connection conn = JdbcUtils.getConnction();
        // 书写sql语句;
        String sql = "insert into sys_user(Uname,UPASSWORD)values('pwdd',null);";
        Statement st = conn.createStatement();
        int resut = st.executeUpdate(sql);
        if (resut >= 1) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        // 关闭连接;
        conn.close();
    }
}
