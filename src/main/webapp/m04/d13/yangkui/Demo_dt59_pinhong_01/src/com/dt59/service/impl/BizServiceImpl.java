/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.bizservice.impl
 * Date:2018年4月12日下午7:17:59
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.User;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:17:59 <br/>
 * 
 * @author YangKui
 * @version
 * @see
 */
public class BizServiceImpl implements BizService {
    private BizDao bizbao;

    public BizDao getBizbao() {
        return bizbao;
    }

    public void setBizbao(BizDao bizbao) {
        this.bizbao = bizbao;
    }

    @Override
    public List<News> getAllNews() {

        // Auto-generated method stub
        return bizbao.getAllNews();
    }

    @Override
    public List<Product> getAllProduct() {
        
        //  Auto-generated method stub
        return bizbao.getAllProduct();
    }

    @Override
    public boolean validateUser(User user) {
        
        //  Auto-generated method stub
        return bizbao.validateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        
        //  Auto-generated method stub
        return bizbao.getAllUser();
    }

    @Override
    public String validate(User user) {
        
        //  Auto-generated method stub
        return bizbao.validate(user);
    }

    
    @Override
    public int getSumCount(Page page) {
        
        //  Auto-generated method stub
        return bizbao.getSumCount(page);
    }

    @Override
    public List<Product> getLimitPage(Page page) {
        
        //  Auto-generated method stub
        return bizbao.getAllProduct();
    }

}
