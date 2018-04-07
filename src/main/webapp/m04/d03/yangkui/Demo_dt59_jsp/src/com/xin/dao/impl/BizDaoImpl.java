

package com.xin.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xin.dao.BaseDao;
import com.xin.dao.BizDao;
import com.xin.entity.NewsInfo;
import com.xin.entity.UserInfo;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:09:53 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public class BizDaoImpl extends BaseDao implements BizDao
{

    @Override
    public boolean denglu(UserInfo user) {
        boolean flag=false;
        String sql="SELECT * FROM user_info WHERE username=? AND PASSWORD=?";
       try {
        pst= getCon().prepareStatement(sql);
        pst.setString(1, user.getName());
        pst.setString(2, user.getPwd());
        rs=pst.executeQuery();
        while(rs.next()){
            flag=true;
        }
    } catch (SQLException e) {
        
        //  Auto-generated catch block
        e.printStackTrace();
        
    }finally{
        close(con, pst, rs);
    }
        return flag;
    }

    @Override
    public List<NewsInfo> all() {
        List<NewsInfo> list=new ArrayList<NewsInfo>();
        String sql="SELECT news_title,news_author FROM news_info";
        try {
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                NewsInfo nf=new NewsInfo();
                nf.setNewsTitle(rs.getString(1));
                nf.setNewsAuthor(rs.getString(2));
                list.add(nf);
            }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }
        return list;
    }

}

