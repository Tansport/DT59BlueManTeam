package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;
import com.dt59.entity.revert;

public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProduct();

    boolean validateUser(User user);

    List<User> getAllUser();

    String getUserRoleByName(String name, String pwd);

    List<Product> getAllProductByPage(Page page);

    int getProductNumber();

    List<Message> getmessage();

    public List<revert> getrevert();

    int setrevert(int mid, String rcontent, String rname);
}
