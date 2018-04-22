package com.dt59.util;

import java.util.UUID;

//����ģʽ�ṩʲô���ܵķ�����
public class TokenUtil {
	//1:�����������򴴽��������
	private TokenUtil(){}
	//2:�ڱ����д���һ���������
	static TokenUtil tu=null;
	//3: �����ṩ������ �����������ȡ�������
	public static TokenUtil getInstance(){
		if(tu==null){
			tu=new TokenUtil();
		}
		return tu;
	}
	//4:uuid  ��������   ˼������α�֤����������У������İ�ȫ��
	public synchronized String get_token(){
		return UUID.randomUUID().toString();
	}
}
