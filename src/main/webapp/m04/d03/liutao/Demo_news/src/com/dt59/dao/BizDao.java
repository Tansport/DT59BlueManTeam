package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Info;
import com.dt59.entity.NewsInfo;
import com.dt59.entity.UserInfo;

public interface BizDao<T> {
    List<Info> getAllInfo();

    int updateInfo(T t);

    int deleteInfo(int id);

    int saveInfo2(T t);

    boolean yanzheng(UserInfo ui);

    List<NewsInfo> addTitle();

}
