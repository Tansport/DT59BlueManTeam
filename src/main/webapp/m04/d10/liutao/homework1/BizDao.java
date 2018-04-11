package com.dt59.dao;

import java.util.List;

import com.dt59.entity.CommentInfo;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.Page;
import com.dt59.entity.UserInfo;

public interface BizDao {
    // 获取数据库user_info表中的数据
    boolean validateUser(UserInfo ui);

    // 获取数据库news_info表中的数据
    List<NewsInfo> addTitle();

    // 删除数据库中的数据
    int delNewsInfoById(int id);

    // 显示新闻信息
    List<CommentInfo> showInfo();

    // 修改信息
    int modification(NewsInfo ni);

    // 分页
    List<NewsInfo> getShowPageByCount(Page page);

    // 总行数查询
    int getSumCount(Page page);
}
