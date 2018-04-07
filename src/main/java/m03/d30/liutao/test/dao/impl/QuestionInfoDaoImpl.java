/**
 * Project Name:study
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:com.test.dao.impl
 * Date:2018年3月28日下午5:14:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.test.dao.BaseDao;
import com.test.dao.QuestionInfoDao;
import com.test.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:14:48 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    // 查询所有
    public List<QuestionInfo> getAllQuery() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            ps = getAllCon().prepareStatement("SELECT * FROM question_info;");
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);

            }

        } catch (Exception e) {

            // Auto-generated catch bloc
            e.printStackTrace();

        } finally {
            close(conn, ps, rs);
        }

        // Auto-generated method stub
        return list;
    }

    // 依据科目查询

    @Override
    public List<QuestionInfo> getsubject(int num) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            ps = getAllCon().prepareStatement("SELECT * FROM question_info WHERE `SUBJECT`=" + num);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }

        // Auto-generated method stub
        return list;
    }

    @Override
    public List<QuestionInfo> getLike(String str) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            ps = getAllCon().prepareStatement("SELECT * FROM question_info WHERE question LIKE '%" + str + "%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        // Auto-generated method stub
        return list;
    }

    @Override
    public int uppdata(Object t) {
        int flag = 0;
        try {
            String sql = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,subject,answer) VALUES(?,?,?,?,?,?,?);";
            Object[] obj = new Object[7];
            if (t instanceof QuestionInfo) {
                QuestionInfo qi = (QuestionInfo) t;// 强转
                obj[0] = qi.getQuestion();
                obj[1] = qi.getOptionA();
                obj[2] = qi.getOptionB();
                obj[3] = qi.getOptionC();
                obj[4] = qi.getOptionD();
                obj[5] = qi.getSubject();
                obj[6] = qi.getAnswer();

            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public int delete(int questionId) {
        int flag = 0;
        try {
            String sql = "DELETE FROM question_info WHERE questionId=?";
            Object[] obj = new Object[1];
            obj[0] = questionId;
            flag = controlDml(sql, obj);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Auto-generated method stub
        return flag;
    }

    @Override
    public List<QuestionInfo> callprodedure() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "CALL ups_question";
            ps = getAllCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }

        return list;
    }

    @Override
    public List<QuestionInfo> callprocedure2(String str) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "CALL ups_questionLike('" + str + "')";
            ps = getAllCon().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                QuestionInfo qi = new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setSubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return list;
    }
};
