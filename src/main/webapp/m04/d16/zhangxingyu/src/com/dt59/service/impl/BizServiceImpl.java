package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;
import com.dt59.entity.revert;
import com.dt59.service.BizService;

public class BizServiceImpl implements BizService {
    private BizDao bizDao;

    public BizDao getBizDao() {
        return bizDao;
    }

    public void setBizDao(BizDao bizDao) {
        this.bizDao = bizDao;
    }

    @Override
    public List<News> getAllNews() {
        // TODO Auto-generated method stub
        return bizDao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {
        // TODO Auto-generated method stub
        return bizDao.getAllProduct();
    }

    @Override
    public boolean validateUser(User user) {
        // TODO Auto-generated method stub
        return bizDao.validateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return bizDao.getAllUser();
    }

    @Override
    public String getUserRoleByName(String name, String pwd) {
        // TODO Auto-generated method stub
        return bizDao.getUserRoleByName(name, pwd);
    }

    @Override
    public List<Product> getAllProductByPage(Page page) {
        // TODO Auto-generated method stub
        return bizDao.getAllProductByPage(page);
    }

    @Override
    public int getProductNumber() {
        // TODO Auto-generated method stub
        return bizDao.getProductNumber();
    }

    @Override
    public List<Message> getmessage() {
        // Auto-generated method stub
        return bizDao.getmessage();
    }

    @Override
    public List<revert> getrevert() {
        // Auto-generated method stub
        return bizDao.getrevert();
    }

    @Override
    public int setrevert(int mid, String rcontent, String rname) {
        // Auto-generated method stub
        return bizDao.setrevert(mid, rcontent, rname);
    }

}
