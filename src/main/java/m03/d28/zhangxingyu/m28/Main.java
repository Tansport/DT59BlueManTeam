/**
 * Project Name:lession1
 * File Name:Main.java
 * Package Name:d03.m28
 * Date:2018年3月28日下午5:47:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m28;

import java.util.List;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:47:51 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class Main {

    public static void main(String[] args) {
        QuestionInfoDao bizDao = new QuestionInfoDaoImpl();// 向上转型
        System.out.println("---------------------原始数据：-----------------------");
        List<QuestionInfo> list = bizDao.getAllInfo();
        for (QuestionInfo ff : list) {
            System.out.println(ff.getQuestionId() + "\t" + ff.getQuestion() + "\t" + ff.getAnswer());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        QuestionInfo info = new QuestionInfo();
        System.out.println("请输入要修改的编号：");
        info.setQuestionId(sc.nextInt());
        System.out.println("请输入要修改的提干:");
        info.setQuestion(sc.next());
        System.out.println("请输入要修改的答案：");
        info.setAnswer(sc.next());
        int flag = bizDao.updateInfo(info);
        if (flag > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
        // System.out.println("请输入要删除的编号:");
        // int id = sc.nextInt();
        // int flag = bizDao.deleteInfo(id);
        // System.out.println("删除的结果：" + flag);
        System.out.println("=====================结果是：======================");
        List<QuestionInfo> list2 = bizDao.getAllInfo();
        for (QuestionInfo ff : list2) {
            System.out.println(ff.getQuestionId() + "\t" + ff.getQuestion() + "\t" + ff.getAnswer());
        }

    }

}
