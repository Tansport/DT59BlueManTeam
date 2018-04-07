/**
 * Project Name:workspace1
 * File Name:Test.java
 * Package Name:lession180328.java
 * Date:2018年3月28日下午5:45:16
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d30.lvwei.lession180330.java;

import java.util.List;

import m03.d30.lvwei.lession180330.dao.QuestionInfoDao;
import m03.d30.lvwei.lession180330.dao.impl.QuestionInfoDaoImpl;
import m03.d30.lvwei.lession180330.entity.QuestionInfo;

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
        List<QuestionInfo> list = bizDao.Callups_test_01();
        for (QuestionInfo ff : list) {
            System.out.println(ff.getQuestionId() + ff.getQuestion() + "\n" + "\t" + "\t" + ff.getOptionA() + "\n"
                    + "\t" + "\t" + ff.getOptionB() + "\n" + "\t" + "\t" + ff.getOptionC() + "\n" + "\t" + "\t"
                    + ff.getOptionD() + "\n" + "\t" + "\t" + ff.getAnswer());
        }

    }
}
