package com.dt59.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 单例模式：生成sqlsession
 * */
public class GetSqlSessionUtil {
	static SqlSessionFactory ssf=null;//接口
	public static GetSqlSessionUtil gsu=null;
	private GetSqlSessionUtil(){}
	public static GetSqlSessionUtil getInstance(){
		if(gsu==null){
			gsu=new GetSqlSessionUtil();
		}
		return gsu;
	}
	public static SqlSessionFactory getsqlsessionfactory_(){
		if(ssf==null){
			//构建
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
