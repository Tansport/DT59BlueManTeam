/**
 * Project Name:Demo_servlet_pinhong
 * File Name:BizServiceImpl.java
 * Package Name:com.servlet.service.impl
 * Date:2018年4月12日下午7:18:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.servlet.service.impl;

import java.util.List;

import com.servlet.basedao.BizDao;
import com.servlet.entity.News;
import com.servlet.entity.Page;
import com.servlet.entity.Product;
import com.servlet.entity.User;
import com.servlet.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:18:03 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public List<News> getAllNews() {

        // Auto-generated method stub
        return bizdao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {

        // Auto-generated method stub
        return bizdao.getAllProduct();
    }

    @Override
    public Boolean getUserInfo(User user) {

        // Auto-generated method stub
        return bizdao.getUserInfo(user);
    }

    @Override
    public List<User> getAllUser() {

        // Auto-generated method stub
        return bizdao.getAllUser();
    }

    @Override
    public String getUstaus(User user) {

        // Auto-generated method stub
        return bizdao.getUstaus(user);
    }

    @Override
    public int getSumCount(Page page) {

        // Auto-generated method stub
        return bizdao.getSumCount(page);
    }

    @Override
    public List<Product> getLimitPage(Page page) {

        // Auto-generated method stub
        return bizdao.getLimitPage(page);
    }

}
