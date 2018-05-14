package com.dt59.until;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 单例模式：生成sqlsession
 * */
public class GetSqlSession {
    static SqlSessionFactory ssf = null;// 接口

    public static GetSqlSession gsu = null;

    private GetSqlSession() {
    }

    public static GetSqlSession getInstance() {
        if (gsu == null) {
            gsu = new GetSqlSession();
        }
        return gsu;
    }

    public static SqlSessionFactory getsqlsessionfactory_() {
        if (ssf == null) {
            // 构建
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                ssf = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ssf;
    }
}
