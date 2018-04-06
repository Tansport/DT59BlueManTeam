package com.dt59.java;

import java.util.List;
import java.util.Scanner;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Info;

public class Test {

	/**
	 * 测试：基本分层后，调用数据
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BizDao bizDao=new BizDaoImpl();//向上转型
		System.out.println("---------------------原始数据：-----------------------");
		List<Info> list= bizDao.getAllInfo();
		for (Info ff : list) {
			System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
		}
		Scanner sc =new Scanner(System.in);
		System.out.println("--------------------------------------");
//		Info info=new Info();
//		System.out.println("请输入要修改的编号：");
//		info.setId(sc.nextInt());
//		System.out.println("请输入要修改的姓名:");
//		info.setName(sc.next());
//		System.out.println("请输入要修改的年龄：");
//		info.setAge(sc.nextInt());
//		int flag=bizDao.updateInfo(info);
//		if(flag>0){
//			System.out.println("修改成功！");
//		}else{
//			System.out.println("修改失败！");
//		}
		System.out.println("请输入要删除的编号:");
		int id=sc.nextInt();
		int flag= bizDao.deleteInfo(id);
		System.out.println("删除的结果："+flag);
		System.out.println("=====================结果是：======================");
		List<Info> list2= bizDao.getAllInfo();
		for (Info ff : list2) {
			System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
		}
		
	}

}
