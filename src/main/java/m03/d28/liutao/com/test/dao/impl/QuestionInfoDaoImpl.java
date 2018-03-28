/**
 * Project Name:study
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.test.dao.impl
 * Date:2018年3月28日下午10:57:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.BaseDao;
import com.test.dao.QuestionInfoDao;
import com.test.entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午10:57:39 <br/>
 * @author   liutao
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllQuery() {
        List<QuestionInfo> list=new ArrayList<QuestionInfo>();
        
        try {
            ps=getAllCon().prepareStatement("SELECT * FROM question_info;");
            rs=ps.executeQuery();
            while(rs.next()){
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);//装箱           
            }
        } catch (SQLException e) {

            e.printStackTrace();
            
        }finally{
            close(conn, ps, rs);
        }
       
        return list;
    }

    @Override
    public List<QuestionInfo> getSubject(int nu) {
        List<QuestionInfo> list=new ArrayList<QuestionInfo>();
        try {
            ps=getAllCon().prepareStatement("SELECT * FROM question_info WHERE subject="+nu+";");
            rs=ps.executeQuery();
            while(rs.next()){
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);//装箱           
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close(conn, ps, rs);
        }
        return list;
    }

    @Override
    public List<QuestionInfo> getLike(String str) {
        List<QuestionInfo> list=new ArrayList<QuestionInfo>();
        try {
            ps=getAllCon().prepareStatement("SELECT * FROM question_info WHERE question LIKE '%"+str+"%'");

            rs=ps.executeQuery();
            while(rs.next()){
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);//装箱           
            }
        } catch (Exception e) {
           e.printStackTrace();
        }finally{
            close(conn, ps, rs);
        }
        
        //  Auto-generated method stub
        return list;
    }

    @Override
    public int updataInfo(Object t) {
        int flag=0;
        try {
            String sql="INSERT INTO question_info(question,optionA,optionB,optionC,optionD,subject,answer) VALUES(?,?,?,?,?,?,?)";
            Object[] obj=new Object[7];
            if(t instanceof QuestionInfo){
                QuestionInfo qi=(QuestionInfo)t;
                obj[5]=qi.getSubject();
                obj[0]=qi.getQuestion();
                obj[1]=qi.getOptionA();
                obj[2]=qi.getOptionB();
                obj[3]=qi.getOptionC();
                obj[4]=qi.getOptionD();
                obj[6]=qi.getAnswer();   
            }
            flag=controlDml(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();           
        }
        return flag;
    }

    @Override
    public int deleteInfo(int dd) {
        int flag=0;
        try {
            String sql ="DELETE FROM question_info WHERE questionId=?";
            Object[] obj=new Object[1];
            obj[0]=dd;
            flag=controlDml(sql, obj);    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}

