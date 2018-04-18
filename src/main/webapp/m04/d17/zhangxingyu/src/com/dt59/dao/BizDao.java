package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.Revert;
import com.dt59.entity.User;

public interface BizDao {
    List<News> getAllNews();

    List<Product> getAllProduct();

    boolean validateUser(User user);

    List<User> getAllUser();

    String getUserRoleByName(String name, String pwd);

    List<Product> getAllProductByPage(Page page);

    int getProductNumber();

    List<Message> getAllMessage();

    Message getMessageById(int id);

    List<Revert> getAllRevert();

    int setrevert(int mid, String rcontent, String rname);

    public int updatemess(int rcount, int mid);

    public int rcount(int mid);
}
