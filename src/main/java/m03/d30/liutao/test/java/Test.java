/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:com.test.java
 * Date:2018年3月28日下午5:31:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.java;

import java.util.List;
import java.util.Scanner;

import com.test.dao.QuestionInfoDao;
import com.test.dao.impl.QuestionInfoDaoImpl;
import com.test.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:31:14 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        // while (true) {
        QuestionInfoDao qi = new QuestionInfoDaoImpl();// 向下转型
        Scanner sca = new Scanner(System.in);
        boolean cc = true;
        while (cc) {

            System.out.println("******************************欢迎使用试题管理系统*********************************");
            System.out.print("请选择操作(1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统):");
            int num = sca.nextInt();
            switch (num) {
            case 1:// 查询所有
                   // List<QuestionInfo> list = qi.getAllQuery();
                List<QuestionInfo> list = qi.callprodedure();// 存贮过程查询所有
                for (QuestionInfo questionInfo : list) {
                    System.out.println(questionInfo.getQuestionId() + "、" + questionInfo.getQuestion() + "\n\t"
                            + "选项A:" + questionInfo.getOptionA() + "\n\t" + "选项B:" + questionInfo.getOptionB() + "\n\t"
                            + "选项C:" + questionInfo.getOptionC() + "\n\t" + "选项D:" + questionInfo.getOptionD() + "\n\t"
                            + "答案:" + questionInfo.getAnswer());
                }

                break;
            case 2:// 按科目查询
                System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
                int num1 = sca.nextInt();
                List<QuestionInfo> list1 = qi.getsubject(num1);
                for (QuestionInfo questionInfo : list1) {
                    System.out.println(questionInfo.getQuestionId() + "、" + questionInfo.getQuestion() + "\n\t"
                            + "选项A:" + questionInfo.getOptionA() + "\n\t" + "选项B:" + questionInfo.getOptionB() + "\n\t"
                            + "选项C:" + questionInfo.getOptionC() + "\n\t" + "选项D:" + questionInfo.getOptionD() + "\n\t"
                            + "答案:" + questionInfo.getAnswer());
                }
                break;
            case 3:// 题干模糊查询
                System.out.print("请输入题干:");
                String st = sca.next();
                // List<QuestionInfo> list2 = qi.getLike(st);
                List<QuestionInfo> list2 = qi.callprocedure2(st);// 存贮过程，模糊查询
                for (QuestionInfo questionInfo : list2) {
                    System.out.println(questionInfo.getQuestionId() + "、" + questionInfo.getQuestion() + "\n\t"
                            + "选项A:" + questionInfo.getOptionA() + "\n\t" + "选项B:" + questionInfo.getOptionB() + "\n\t"
                            + "选项C:" + questionInfo.getOptionC() + "\n\t" + "选项D:" + questionInfo.getOptionD() + "\n\t"
                            + "答案:" + questionInfo.getAnswer());
                }
                break;
            case 4:// 添加题目
                QuestionInfo qq = new QuestionInfo();
                System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
                int num2 = sca.nextInt();
                qq.setSubject(num2);
                System.out.print("请输入新的题干:");
                String str = sca.next();
                qq.setQuestion(str);
                System.out.print("请输入新的选项A:");
                String str1 = sca.next();
                qq.setOptionA(str1);
                System.out.print("请输入新的选项B:");
                String str2 = sca.next();
                qq.setOptionB(str2);
                System.out.print("请输入新的选项C:");
                String str3 = sca.next();
                qq.setOptionC(str3);
                System.out.print("请输入新的选项D:");
                String str4 = sca.next();
                qq.setOptionD(str4);
                System.out.print("请输入新的答案:");
                String str5 = sca.next();
                qq.setAnswer(str5);
                int flag = qi.uppdata(qq);
                if (flag > 0) {
                    System.out.println("添加成功！");

                } else {
                    System.out.println("添加失败！");

                }

                break;
            case 5:// 删除试题
                boolean tt = true;
                while (tt) {
                    System.out.print("请输入要删除的试题编号:");
                    int questionId = sca.nextInt();
                    int flag1 = qi.delete(questionId);
                    if (flag1 > 0) {
                        System.out.println("删除成功！");
                        tt = false;

                    } else {
                        System.out.println("对不起,没有要删除的编号!,请重新输入");
                    }
                }
                break;
            case 6:// 退出程序
                System.out.println("成功退出!");
                cc = false;
            default:
                System.out.println("输入有误，请重新输入(1-6)");
            }
        }
        sca.close();
        // }
    }
}
