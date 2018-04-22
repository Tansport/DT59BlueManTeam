/**
 * Project Name:Demo_dt59_shopping
 * File Name:BizServiceImpl.java
 * Package Name:com.dt59.serevice.impl
 * Date:2018年4月19日下午4:14:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.serevice.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.entity.MingXi;
import com.dt59.entity.ShangPin;
import com.dt59.entity.User;
import com.dt59.service.BizService;

/**
 * Description:   <br/>
 * Date:     2018年4月19日 下午4:14:10 <br/>
 * @author   YangKui
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
    public List<ShangPin> getAllShangPin() {
        
        //  Auto-generated method stub
        return bizdao.getAllShangPin();
    }

    @Override
    public boolean validateUser(User user) {
        
        //  Auto-generated method stub
        return bizdao.validateUser(user);
    }

    @Override
    public ShangPin getShangpinById(int id) {
        
        //  Auto-generated method stub
        return bizdao.getShangpinById(id);
    }

    @Override
    public List<MingXi> getAllMingXi() {
        
        //  Auto-generated method stub
        return bizdao.getAllMingXi();
    }

}

