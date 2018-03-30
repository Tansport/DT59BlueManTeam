/**
 * Project Name:Demo_jdbc_fc
 * File Name:Main.java
 * Package Name:Text
 * Date:2018年3月28日下午5:14:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.List;
import java.util.Scanner;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:14:59 <br/>
 * 
 * @author
 * @version
 * @see
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BizDao biz = new BizDaoImpl();
        boolean flag10 = true;

        while (flag10) {
            System.out.println("**********************************");
            System.out.println("请选择操作(1.列出所有试题  2.按科目查询  3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统)");
            int num = sc.nextInt();// 接收用户输入的编号
            if (num == 1) {
                // 显示所有题目
                List<QuestionInfo> list = biz.getAllInfo();
                System.out.println("");
                for (QuestionInfo ff : list) {
                    System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + ff.getOptionA() + "\n"
                            + "\t" + ff.getOptionB() + "\n" + "\t" + ff.getOptionC() + "\n" + "\t" + ff.getOptionD()
                            + "\n" + "\t" + ff.getAnswer());
                }
            } else if (num == 2) {
                // 显示科目的题目
                System.out.print("请输入科目:（1.JAVA 2.C# 3.JSP）");
                int i = sc.nextInt();
                List<QuestionInfo> list2 = biz.getAllInfo(i);
                System.out.println("");
                for (QuestionInfo ff : list2) {
                    System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + ff.getOptionA() + "\n"
                            + "\t" + ff.getOptionB() + "\n" + "\t" + ff.getOptionC() + "\n" + "\t" + ff.getOptionD()
                            + "\n" + "\t" + ff.getAnswer());
                }
            } else if (num == 3) {
                // 显示题干模糊查询
                System.out.print("请输入题干:");
                String str = sc.next();
                List<QuestionInfo> list3 = biz.getAllInfo(str);
                System.out.println("");
                for (QuestionInfo ff : list3) {
                    System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + ff.getOptionA() + "\n"
                            + "\t" + ff.getOptionB() + "\n" + "\t" + ff.getOptionC() + "\n" + "\t" + ff.getOptionD()
                            + "\n" + "\t" + ff.getAnswer());
                }
            } else if (num == 4) {
                // 添加试题
                QuestionInfo qinfo = new QuestionInfo();

                System.out.print("请输入科目:(1.JAVA 2.C# 3.JSP)");
                qinfo.setSubject(sc.nextInt());
                System.out.print("请输入新的题干：");
                qinfo.setQuestion(sc.next());
                System.out.print("请输入新的选项A：");
                qinfo.setOptionA(sc.next());
                System.out.print("请输入新的选项B：");
                qinfo.setOptionB(sc.next());
                System.out.print("请输入新的选项C：");
                qinfo.setOptionC(sc.next());
                System.out.print("请输入新的选项D：");
                qinfo.setOptionD(sc.next());
                System.out.print("请输入新的答案");
                qinfo.setAnswer(sc.next());

                int flag1 = biz.saveQuestionInfo(qinfo);
                if (flag1 > 0) {
                    System.out.println("添加成功！");
                } else {
                    System.out.println("添加失败！");
                }

            } else if (num == 5) {
                // 删除试题
                boolean flag11 = true;
                System.out.println("请输入需要删除的试题编号:");
                while (flag11) {
                    int i = sc.nextInt();// 用来接收删除的编号
                    // QuestionInfo qinfo = new QuestionInfo();
                    // System.out.println(qinfo.getQuestionId());
                    // int j = biz.deleteInfo(i);
                    // 如何将question_info中的questionID取出，然后与输入的i进行匹配？
                    // if (i != j) {
                    // System.out.println("对不起，没有要删除的编号！请重新输入");
                    // } else {
                    int flag = biz.deleteInfo(i);
                    // System.out.println("删除的结果：" + flag);
                    if (flag > 0) {
                        System.out.println("删除成功！");
                        flag11 = false;
                    } else {
                        System.out.println("对不起，没有要删除的编号！请重新输入！");
                    }
                    // }
                }
            } else if (num == 6) {
                System.out.println("欢迎下次来学习！");
                flag10 = false;
            }
        }
        sc.close();
    }

}
