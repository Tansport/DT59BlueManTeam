/**
 * Project Name:lession1
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:d03.m28
 * Date:2018年3月28日下午5:19:14
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package d03.m28;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午5:19:14 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @param <T>
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllInfo() {
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
        // Auto-generated method stub
        return list;
    }

    @Override
    public int updateInfo(Object t) {
        int flag = 0;
        try {
            String sql = "UPDATE info SET questionId=?,question=? WHERE questionId=?";
            Object[] obj = new Object[8];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;// 向下转型
                obj[0] = ff.getQuestionId();
                obj[1] = ff.getQuestion();
                obj[2] = ff.getOptionA();
                obj[3] = ff.getOptionB();
                obj[4] = ff.getOptionC();
                obj[5] = ff.getOptionD();
                obj[6] = ff.getSubject();
                obj[7] = ff.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
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
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int saveInfo2(Object t) {
        int flag = 0;
        try {
            String sql = "INSERT INTO question_info(NAME,birthday) VALUES(?,?)";
            Object[] obj = new Object[8];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                obj[0] = ff.getQuestionId();
                obj[1] = ff.getQuestion();
                obj[2] = ff.getOptionA();
                obj[3] = ff.getOptionB();
                obj[4] = ff.getOptionC();
                obj[5] = ff.getOptionD();
                obj[6] = ff.getSubject();
                obj[7] = ff.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

}
