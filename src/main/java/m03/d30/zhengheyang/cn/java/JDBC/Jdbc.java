package cn.java.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * Description: <br/>
 * date: Mar 28, 2018 3:47:21 PM <br/>
 *
 * @author zhengheyang
 * @version
 */
public class Jdbc {
    public static void main(String[] args) throws Exception {
        Jdbc jc = new Jdbc();
        jc.testProperties();
    }

    public void testProperties() throws Exception {
        Properties ps = new Properties();
        InputStream ins = Jdbc.class.getClassLoader().getResourceAsStream("database.properties");
        ps.load(ins);
        String driver = ps.getProperty("driver");
        String ulr = ps.getProperty("ulr");
        String username = ps.getProperty("username");
        String password = ps.getProperty("password");
        System.out.println(driver);
        System.out.println(ulr);
        System.out.println(username);
        System.out.println(password);
    }
}
