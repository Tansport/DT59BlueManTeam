/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizDaoServiceImpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年4月19日下午12:59:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.Shopping;
import com.dt59.entity.User;
import com.dt59.service.BizDaoService;

/**
 * Description: <br/>
 * Date: 2018年4月19日 下午12:59:02 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class BizDaoServiceImpl implements BizDaoService {
    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public List<Shopping> getAllShopping() {

        // Auto-generated method stub
        return bizdao.getAllShopping();
    }

    @Override
    public boolean getAllUser(User User) {

        // Auto-generated method stub
        return bizdao.getAllUser(User);
    }

    @Override
    public Shopping getAllbyId(int sid) {

        // Auto-generated method stub
        return bizdao.getAllbyId(sid);
    }

}
