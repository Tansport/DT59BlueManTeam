/**
 * Project Name:workspace1
 * File Name:Test.java
 * Package Name:lession180328.java
 * Date:2018年3月28日下午5:45:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.lvwei.src.lession180328.java;

import java.util.List;
import java.util.Scanner;

import m03.d28.lvwei.src.lession180328.dao.QuestionInfoDao;
import m03.d28.lvwei.src.lession180328.dao.impl.QuestionInfoDaoImpl;
import m03.d28.lvwei.src.lession180328.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:45:16 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        QuestionInfoDao bizDao = new QuestionInfoDaoImpl();// 向上转型
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("---------------------原始数据：-----------------------");
            System.out.print("请选择操作（1.列出所有试题  2.按科目查询  3.按题干模糊查询   4.添加试题  5.删除试题  6.退出系统）");
            int t = sc.nextInt();
            if (t == 1) {
                List<QuestionInfo> list = bizDao.getAllInfo();
                for (QuestionInfo ff : list) {
                    System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA()
                            + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n" + "\t"
                            + "\t" + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
                }
                continue;
            } else if (t == 2) {
                System.out.println("请输入科目：（1.JAVA 2.C# 3.JSP）");
                int t1 = sc.nextInt();
                if (t1 == 1) {
                    List<QuestionInfo> list = bizDao.getjava();
                    for (QuestionInfo ff : list) {
                        System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA()
                                + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n"
                                + "\t" + "\t" + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
                    }
                    continue;
                } else if (t1 == 2) {
                    List<QuestionInfo> list = bizDao.getC();
                    for (QuestionInfo ff : list) {
                        System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA()
                                + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n"
                                + "\t" + "\t" + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
                    }
                } else if (t1 == 3) {
                    List<QuestionInfo> list = bizDao.getJSP();
                    for (QuestionInfo ff : list) {
                        System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA()
                                + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n"
                                + "\t" + "\t" + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
                    }
                    continue;
                }

            } else if (t == 3) {
                System.out.print("请输入题干：");
                String cont = sc.next();
                List<QuestionInfo> list = bizDao.getcont(cont);
                for (QuestionInfo ff : list) {
                    System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA()
                            + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n" + "\t"
                            + "\t" + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
                }
                continue;
            } else if (t == 4) {
                QuestionInfo qi = new QuestionInfo();
                System.out.println("请输入科目：（1.Java 2.C# 3.JSP ）：");
                qi.setSubject(sc.nextInt());
                System.out.println("请输入题干：");
                qi.setQuestion(sc.next());
                System.out.println("请输入选项A：");
                qi.setOptionA(sc.next());
                System.out.println("请输入选项B：");
                qi.setOptionB(sc.next());
                System.out.println("请输入选项C：");
                qi.setOptionC(sc.next());
                System.out.println("请输入选项D：");
                qi.setOptionD(sc.next());
                System.out.println("请输入答案：");
                qi.setAnswer(sc.next());
                int flag = bizDao.saveInfo2(qi);
                if (flag > 0) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
                continue;
            } else if (t == 5) {
                while (true) {
                    System.out.println("请输入需要删除的试题编号");
                    int t1 = sc.nextInt();
                    if (t1 < 6) {
                        int flag = bizDao.deleteInfo(t1);
                        System.out.println("删除的结果：" + flag);
                        List<QuestionInfo> list2 = bizDao.getAllInfo();
                        for (QuestionInfo ff : list2) {
                            System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t"
                                    + ff.getOptionA() + "\n" + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t"
                                    + ff.getOptionC() + "\n" + "\t" + "\t" + ff.getOptionD() + "\n" + "\t" + "\t"
                                    + ff.getAnswer());

                        }
                        break;
                    } else {
                        System.out.println("对不起请重新输入");
                    }
                }

            } else if (t == 6) {
                System.out.println("已成功退出");
                b = false;
            }
        }
    }
}
