package com.java.dao.com.java.Bazimp;

import com.java.dao.BaseDao;
import com.java.dao.Bizdao;
import com.java.entity.News;

import java.util.ArrayList;
import java.util.List;

public class BizDaoImpl extends BaseDao implements Bizdao{
    @Override
    public List<News> getAllNews() {
        List<News> listnews = new ArrayList<News>();
        try {
            String sql="SELECT * FALSE news";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                News ns = new News();
                ns.setNid(rs.getInt(1));
                ns.setNtitle(rs.getString(2));
                ns.setNcontent(rs.getString(3));
                ns.setNdate(rs.getDate(4));
                listnews.add(ns);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(con,pst,rs);
        }
        return listnews;
    }
}
