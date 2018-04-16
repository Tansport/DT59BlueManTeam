/**
 * Project Name:Demo_dt59_jsp06_04_12
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月12日下午7:10:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.News;
import com.dt59.entity.Product;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年4月12日 下午7:10:07 <br/>
 * 
 * @author zhangxingyu
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
    public List<Product> getALLProduct() {

        // Auto-generated method stub
        return bizdao.getALLProduct();
    }
}
