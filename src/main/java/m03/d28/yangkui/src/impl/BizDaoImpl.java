/**
 * Project Name:Demo_jdbc_fc
 * File Name:BizDaoImpl.java
 * Package Name:dao.impl
 * Date:2018年3月28日下午4:43:24
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.BizDao;
import entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:43:24 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao {

    @Override
    // 重写查询方法
    public List<QuestionInfo> getAllInfo() {

        // Auto-generated method stub
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
                ff.setAnswer(rs.getString(8));
                ff.setSubject(rs.getInt(7));
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
    // 重写按指定科目查询方法
    public List<QuestionInfo> getAllInfo(int i) {

        // Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info where subject = " + i;
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
                ff.setAnswer(rs.getString(8));
                ff.setSubject(rs.getInt(7));
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
    // 按照关键词模糊查询方法
    public List<QuestionInfo> getAllInfo(String str) {

        // Auto-generated method stub
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info where question like '%" + str + "%'";
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
                ff.setAnswer(rs.getString(8));
                ff.setSubject(rs.getInt(7));
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
    // 按照科目删除方法
    public int deleteInfo(int id) {

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
    public int saveQuestionInfo(Object t) {

        // TODO Auto-generated method stub
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
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    }
       
    
    


