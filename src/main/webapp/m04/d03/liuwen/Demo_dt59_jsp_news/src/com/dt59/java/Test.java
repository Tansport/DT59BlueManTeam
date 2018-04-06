/**
 * Project Name:Demo_dt59_jsp_news
 * File Name:Test.java
 * Package Name:com.dt59.java
 * Date:2018年4月5日上午10:39:30
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.java;

import java.util.ArrayList;
import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.NewsInfo;

/**
 * Description: <br/>
 * Date: 2018年4月5日 上午10:39:30 <br/>
 * 
 * @author WEN LIU
 * @version
 * @see
 */
// 测试类，判断是否已经从数据库中取出新闻
// 结论，可以将数据取出
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<NewsInfo> list = new ArrayList<NewsInfo>();
        NewsInfo newsinfo = new NewsInfo();
        BizDao biz = new BizDaoImpl();
        list = biz.validateNewsInfo(newsinfo);
        for (NewsInfo newsinfo1 : list) {
            System.out.println(newsinfo1.getNewstitle() + "\t" + newsinfo1.getNewsauthor());
        }

        // Iterator iterator = list.iterator();
        // if (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }
    }
}
