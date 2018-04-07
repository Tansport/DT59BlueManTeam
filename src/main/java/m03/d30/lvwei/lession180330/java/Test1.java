/**
 * Project Name:workspace1
 * File Name:Test1.java
 * Package Name:lession180330.java
 * Date:2018年3月30日下午8:28:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.lvwei.lession180330.java;

import java.util.List;
import java.util.Scanner;

import m03.d30.lvwei.lession180330.dao.QuestionInfoDao;
import m03.d30.lvwei.lession180330.dao.impl.QuestionInfoDaoImpl;
import m03.d30.lvwei.lession180330.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午8:28:43 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class Test1 {

    public static void main(String[] args) {
        QuestionInfoDao bizDao = new QuestionInfoDaoImpl();// 向上转型
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入模糊题干");
        String srt = sc.next();
        List<QuestionInfo> list = bizDao.Callups_test_02(srt);
        for (QuestionInfo ff : list) {
            System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA() + "\n"
                    + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n" + "\t" + "\t"
                    + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
        }

    }
}
