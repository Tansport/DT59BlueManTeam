/**
 * Project Name:workJSP
 * File Name:BizDao.java
 * Package Name:dao
 * Date:2018年4月3日下午11:08:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package dao;

import java.util.List;

import entity.Message;
import entity.News;
import entity.Page;
import entity.Product;
import entity.User;
import entity.revert;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午11:08:32 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();

    List<Product> getALLProduct();

    boolean validateUser(User user);

    String AllUser(User user);

    List<User> getAllUser();

    List<Page> sum();

    List<Product> newslist(Page page);

    List<Message> getmessage();

    public List<revert> getrevert();

    int setrevert(int mid, String rcontent, String rname);

    public int updatemess(int rcount, int mid);

    public int rcount(int mid);
}
