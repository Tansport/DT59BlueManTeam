package com.dt59.dao;

import java.util.List;

import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;
import com.dt59.entity.XinInfo;

public interface BizDao {
	boolean validateUser(UserInfo user);
	
	List<NewsInfo> getNews();
	
	int delNewsInfoById(int id);
	
	List<XinInfo> getxin();

    int add(Object t);
    
    List<NewsInfo> getNewsInfoByPage(Page page);
    
    List<Page> getFeng();
}
