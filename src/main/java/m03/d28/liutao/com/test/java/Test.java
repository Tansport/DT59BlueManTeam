/**
 * Project Name:study
 * File Name:Test.java
 * Package Name:com.test.java
 * Date:2018年3月28日下午11:13:56
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.java;

import java.util.List;
import java.util.Scanner;

import com.test.dao.QuestionInfoDao;
import com.test.dao.impl.QuestionInfoDaoImpl;
import com.test.entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午11:13:56 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class Test {
    public static void main(String[] args) {

        QuestionInfoDao qid=new QuestionInfoDaoImpl();//多态向下转型
        System.out.println("*****************************欢迎使用试题管理系统***********************************");
        System.out.print("请选择操作(1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统):");
        Scanner sca=new Scanner(System.in);
        int num=sca.nextInt();
        switch (num) {
        case 1:
            List<QuestionInfo> list=qid.getAllQuery();
            for (QuestionInfo questionInfo : list) {
                System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion()+"\n\t"
                        +"选项A:"+questionInfo.getOptionA()+"\n\t"
                        +"选项B:"+questionInfo.getOptionB()+"\n\t"
                        +"选项C:"+questionInfo.getOptionC()+"\n\t"
                        +"选项D:"+questionInfo.getOptionD()+"\n\t"
                        +"答案:"+questionInfo.getAnswer()
                        );                
            }           
            break;
        case 2:
            System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
            int n=sca.nextInt();
            List<QuestionInfo> list2=qid.getSubject(n);
            for (QuestionInfo questionInfo : list2) {
                System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion()+"\n\t"
                        +"选项A:"+questionInfo.getOptionA()+"\n\t"
                        +"选项B:"+questionInfo.getOptionB()+"\n\t"
                        +"选项C:"+questionInfo.getOptionC()+"\n\t"
                        +"选项D:"+questionInfo.getOptionD()+"\n\t"
                        +"答案:"+questionInfo.getAnswer()
                        );                
            } 
            break;
        case 3:
            System.out.print("请输入题干:");
            String name=sca.next();
            List<QuestionInfo> list3=qid.getLike(name);
            for (QuestionInfo questionInfo : list3) {
                System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion()+"\n\t"
                        +"选项A:"+questionInfo.getOptionA()+"\n\t"
                        +"选项B:"+questionInfo.getOptionB()+"\n\t"
                        +"选项C:"+questionInfo.getOptionC()+"\n\t"
                        +"选项D:"+questionInfo.getOptionD()+"\n\t"
                        +"答案:"+questionInfo.getAnswer()
                        );                
            } 
    
            break;
    
        case 4:
            QuestionInfo ff=new QuestionInfo();
            System.out.print("请输入科目:(1.Java 2.C# 3.JSP):");
            ff.setSubject(sca.nextInt());
            System.out.print("请输入新的题干:");
            ff.setQuestion(sca.next());
            System.out.print("请输入新的选项A:");
            ff.setOptionA(sca.next());
            System.out.print("请输入新的选项B:");
            ff.setOptionB(sca.next());
            System.out.print("请输入新的选项C:");
            ff.setOptionC(sca.next());
            System.out.print("请输入新的选项D:");
            ff.setOptionD(sca.next());
            System.out.print("请输入新的答案:");
            ff.setAnswer(sca.next());
            int flag=qid.updataInfo(ff);
            if(flag>0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
    
            break;
        case 5:
            while(true){
            System.out.print("请输入科目要删除的试题编号:");
            int dd=sca.nextInt();
            flag=qid.deleteInfo(dd);
            if(flag>0){
                System.out.println("删除成功！");
                break;
            }else{
                System.out.println("对不起，没有要删除的编号！,请重新输入");
            }
            }
            
            break;
        case 6:
            System.out.println("系统退出成功！");
            
            break;

        default:
            break;
        }
       
        sca.close();
    }
    

}

