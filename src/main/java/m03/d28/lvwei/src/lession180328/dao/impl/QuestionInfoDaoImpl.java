/**
 * Project Name:workspace1
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:lession180328.dao.impl
 * Date:2018年3月28日下午5:07:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.lvwei.src.lession180328.dao.impl;

import java.util.ArrayList;
import java.util.List;

import m03.d28.lvwei.src.lession180328.dao.BaseDao;
import m03.d28.lvwei.src.lession180328.dao.QuestionInfoDao;
import m03.d28.lvwei.src.lession180328.entity.QuestionInfo;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:07:04 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */

public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    // 查询所有
    public List<QuestionInfo> getAllInfo() {
        // TODO Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    // 按科目查
    public List<QuestionInfo> getjava() {
        // TODO Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info WHERE SUBJECT=1";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    public List<QuestionInfo> getC() {
        // TODO Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info WHERE SUBJECT=2";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    public List<QuestionInfo> getJSP() {
        // TODO Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info WHERE SUBJECT=3";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, "%+cont+%");
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    // 按题干查询
    public List<QuestionInfo> getcont(String cont) {
        // TODO Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info WHERE question LIKE ?";
            pst = getCon().prepareStatement(sql);
            pst.setString(1, "%" + cont + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    // 删除试题
    public int deleteInfo(int id) {

        // Auto-generated method stub
        int flag = 0;
        try {
            String sql = "DELETE FROM question_info WHERE questionId=?";
            Object[] obj = new Object[1];
            obj[0] = id;
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    // 添加试题
    public int saveInfo2(Object t) {
        int flag = 0;
        try {
            String sql = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,subject,answer) VALUES(?,?,?,?,?,?,?)";
            Object[] obj = new Object[7];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                obj[0] = ff.getQuestion();
                obj[1] = ff.getOptionA();
                obj[2] = ff.getOptionB();
                obj[3] = ff.getOptionC();
                obj[4] = ff.getOptionD();
                obj[5] = ff.getSubject();
                obj[6] = ff.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

}
