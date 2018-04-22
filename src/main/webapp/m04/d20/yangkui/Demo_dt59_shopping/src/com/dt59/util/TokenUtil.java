package com.dt59.util;

import java.util.UUID;

//单例模式提供什么功能的方法！
public class TokenUtil {
	//1:不让其他程序创建该类对象
	private TokenUtil(){}
	//2:在本类中创建一个本类对象。
	static TokenUtil tu=null;
	//3: 对外提供方法， 让其他程序获取这个对象
	public static TokenUtil getInstance(){
		if(tu==null){
			tu=new TokenUtil();
		}
		return tu;
	}
	//4:uuid  创建令牌   思考：如何保证多个访问者中，方法的安全性
	public synchronized String get_token(){
		return UUID.randomUUID().toString();
	}
}
