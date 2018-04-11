package com.dt59.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BaseDao;
import com.dt59.dao.BizDao;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;
import com.dt59.entity.XinInfo;

public class BizDaoImpl extends BaseDao implements BizDao {

	public boolean validateUser(UserInfo user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			String sql="SELECT * FROM user_info a WHERE a.`username`=? AND a.`password`=?";
			pst=getCon().prepareStatement(sql);
			//��ֵ
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			//ִ��
			rs=pst.executeQuery();
			while(rs.next()){
				flag=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

	public List<NewsInfo> getNews() {
		// TODO Auto-generated method stub
		List<NewsInfo> listnews=new ArrayList<NewsInfo>();
		try {
			String sql="SELECT * FROM news_info";
			pst=getCon().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				NewsInfo info=new NewsInfo();
				info.setNewsid(rs.getInt(1));
				info.setTypeid(rs.getInt(2));
				info.setNewstitle(rs.getString(3));
				info.setNewsauthor(rs.getString(4));
				info.setNewssummary(rs.getString(5));
				info.setNewscontent(rs.getString(6));
				info.setNewspic(rs.getString(7));
				listnews.add(info);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return listnews;
	}

	public int delNewsInfoById(int id) {
		// TODO Auto-generated method stub
		int flag=0;
		try {
			String sql="DELETE FROM news_info WHERE news_id=?";
			pst=getCon().prepareStatement(sql);
			pst.setInt(1, id);
			flag= pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			close(con,pst,rs);
		}
		return flag;
	}

    @Override
    public List<XinInfo> getxin() {
        
        List<XinInfo> listnews=new ArrayList<XinInfo>();
        try {
            String sql="SELECT * FROM comment_info";
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                XinInfo info=new XinInfo();
                info.setComment_id(rs.getInt(1));
                info.setUsername(rs.getString(2));
                info.setIp(rs.getString(3));
                info.setContent(rs.getString(4));
                info.setNews_id(rs.getInt(5));
                info.setFbtime(rs.getDate(6));
                listnews.add(info);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            close(con,pst,rs);
        }
        return listnews;
    }
    @Override
    public int add(Object t) {
        int flag = 0;
        String sql = "UPDATE news_info SET news_title=?,news_author=? WHERE news_id=?";
        Object[] obj = new Object[3];
        if (t instanceof NewsInfo) {
            NewsInfo nf = (NewsInfo) t;
            obj[0] = nf.getNewstitle();
            obj[1] = nf.getNewsauthor();
            obj[2] = nf.getNewsid();
        }
        flag=controlDml(sql, obj);
        return flag;
    }

    @Override
    public List<NewsInfo> getNewsInfoByPage(Page page) {
        List<NewsInfo> list1=new ArrayList<NewsInfo>();
        try {
            String sql="SELECT * FROM `news_info` LIMIT ?,?";
            pst=getCon().prepareStatement(sql);
            pst.setInt(1,(page.getCurrentpage()-1) * page.getPagesize());
            pst.setInt(2, page.getPagesize());
            rs=pst.executeQuery();
            while(rs.next()){
                NewsInfo info=new NewsInfo();
                info.setNewsid(rs.getInt(1));
                info.setTypeid(rs.getInt(2));
                info.setNewstitle(rs.getString(3));
                info.setNewsauthor(rs.getString(4));
                info.setNewssummary(rs.getString(5));
                info.setNewscontent(rs.getString(6));
                info.setNewspic(rs.getString(7));
                list1.add(info);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  Auto-generated method stub
        return list1;
    }

    @Override
    public List<Page> getFeng() {
        List<Page> list=new ArrayList<Page>();
        String sql="SELECT COUNT(*) FROM `news_info`";
        
        try {
            pst=getCon().prepareStatement(sql);
           rs=pst.executeQuery();
           while(rs.next()){
               Page page=new Page();
               page.setPagesize(rs.getInt(1));
               list.add(page);
           }
        } catch (Exception e) {
            // TODO: handle exception
        }
        //  Auto-generated method stub
        return list;
    }

}
