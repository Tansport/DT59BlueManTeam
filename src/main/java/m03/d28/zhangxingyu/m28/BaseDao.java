/**
 * Project Name:lession1
 * File Name:QuestionInfo.java
 * Package Name:d03.m28
 * Date:2018年3月28日下午2:31:35
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m28;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午2:31:35 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BaseDao {
    protected Connection con = null;

    protected PreparedStatement pst = null;

    protected ResultSet rs = null;

    static String questionId;

    static String question;

    static String optionA;

    static String OptionB;

    static String OptionC;

    static String OptionD;

    static String subject;

    static String answer;
    static {
        init();
    }

    private static void init() {
        Properties pro = new Properties();
        String path = "database.properties";
        try {
            InputStream ist = BaseDao.class.getClassLoader().getResourceAsStream(path);
            pro.load(ist);
            questionId = pro.getProperty(question);
            question = pro.getProperty(question);
            optionA = pro.getProperty(optionA);
            OptionB = pro.getProperty(OptionB);
            OptionC = pro.getProperty(OptionC);
            OptionD = pro.getProperty(OptionD);
            subject = pro.getProperty(subject);
            answer = pro.getProperty(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        try {
            Class.forName(questionId);
            con = DriverManager.getConnection(questionId, question, optionA);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;
    }

    public int controlDml(String sql, Object[] obj) {
        int flag = 0;
        try {
            pst = getCon().prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pst.setObject(i + 1, obj[i]);
                }
            }
            flag = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
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
