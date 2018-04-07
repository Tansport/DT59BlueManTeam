/**
 * Project Name:lession1
 * File Name:BizDaoImpl.java
 * Package Name:d03.m29.dao.impl
 * Date:2018年3月30日下午8:51:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m29.dao.impl;

import java.util.ArrayList;
import java.util.List;

import d03.m29.dao.BaseDao;
import d03.m29.dao.BizDao;
import d03.m29.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午8:51:03 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao<Object> {

    @Override
    public List<QuestionInfo> getAllInfo() {

        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qinfo = new QuestionInfo();
                qinfo.setQuestionId(rs.getInt(1));
                qinfo.setQuestion(rs.getString(2));
                qinfo.setOptionA(rs.getString(3));
                qinfo.setOptionB(rs.getString(4));
                qinfo.setOptionC(rs.getString(5));
                qinfo.setOptionD(rs.getString(6));
                qinfo.setAnswer(rs.getString(8));
                qinfo.setSubject(rs.getInt(7));
                list.add(qinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public List<QuestionInfo> getAllInfo(int i) {

        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info where subject = " + i;
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qinfo = new QuestionInfo();
                qinfo.setQuestionId(rs.getInt(1));
                qinfo.setQuestion(rs.getString(2));
                qinfo.setOptionA(rs.getString(3));
                qinfo.setOptionB(rs.getString(4));
                qinfo.setOptionC(rs.getString(5));
                qinfo.setOptionD(rs.getString(6));
                qinfo.setAnswer(rs.getString(8));
                qinfo.setSubject(rs.getInt(7));
                list.add(qinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    // 按照关键词模糊查询方法
    public List<QuestionInfo> getAllInfo(String str) {

        // Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info where question like '%" + str + "%'";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qinfo = new QuestionInfo();
                qinfo.setQuestionId(rs.getInt(1));
                qinfo.setQuestion(rs.getString(2));
                qinfo.setOptionA(rs.getString(3));
                qinfo.setOptionB(rs.getString(4));
                qinfo.setOptionC(rs.getString(5));
                qinfo.setOptionD(rs.getString(6));
                qinfo.setAnswer(rs.getString(8));
                qinfo.setSubject(rs.getInt(7));
                list.add(qinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public int deleteInfo(int id) {

        int flag = 0;
        try {
            String sql = "DELETE FROM question_info WHERE questionId=?";
            Object[] obj = new Object[1];
            obj[0] = id;
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int saveQuestionInfo(Object t) {

        int flag = 0;
        try {
            String sql = "INSERT INTO `question_info` (`question`,`optionA`,`optionB`,`optionC`,`optionD`,`SUBJECT`,`answer`) VALUES (?,?,?,?,?,?,?)";

            Object[] obj = new Object[7];
            if (t instanceof QuestionInfo) {
                QuestionInfo qinfo = (QuestionInfo) t;
                obj[0] = qinfo.getQuestion();
                obj[1] = qinfo.getOptionA();
                obj[2] = qinfo.getOptionB();
                obj[3] = qinfo.getOptionC();
                obj[4] = qinfo.getOptionD();
                obj[5] = qinfo.getSubject();
                obj[6] = qinfo.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<QuestionInfo> callprocedure() {
        // Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "CALL ups_test_01";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qinfo = new QuestionInfo();
                qinfo.setQuestionId(rs.getInt(1));
                qinfo.setQuestion(rs.getString(2));
                qinfo.setOptionA(rs.getString(3));
                qinfo.setOptionB(rs.getString(4));
                qinfo.setOptionC(rs.getString(5));
                qinfo.setOptionD(rs.getString(6));
                qinfo.setAnswer(rs.getString(8));
                qinfo.setSubject(rs.getInt(7));
                list.add(qinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public List<QuestionInfo> callprocedure2(String str) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "CALL ups_test_02('" + str + "')";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo qinfo = new QuestionInfo();
                qinfo.setQuestionId(rs.getInt(1));
                qinfo.setQuestion(rs.getString(2));
                qinfo.setOptionA(rs.getString(3));
                qinfo.setOptionB(rs.getString(4));
                qinfo.setOptionC(rs.getString(5));
                qinfo.setOptionD(rs.getString(6));
                qinfo.setAnswer(rs.getString(8));
                qinfo.setSubject(rs.getInt(7));
                list.add(qinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;

    }

    @Override
    public int saveInfo(Object t) {
        return 0;
    }

}
