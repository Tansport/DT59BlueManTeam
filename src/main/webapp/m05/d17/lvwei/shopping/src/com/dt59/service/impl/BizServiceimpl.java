/**
 * Project Name:shopping
 * File Name:BizServiceimpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年5月17日下午4:50:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Bill;
import com.dt59.pojo.User;
import com.dt59.service.BizService;

/**
 * Description: <br/>
 * Date: 2018年5月17日 下午4:50:02 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class BizServiceimpl implements BizService {
    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public List<User> validateUser(User us) {

        // Auto-generated method stub
        return bizdao.validateUser(us);
    }

    @Override
    public List<Bill> getAllBill() {

        // Auto-generated method stub
        return bizdao.getAllBill();
    }

    @Override
    public List<String> getProviderByTinc() {

        // Auto-generated method stub
        return bizdao.getProviderByTinc();
    }

    @Override
    public List<String> getSmbmsBillIspay() {

        // Auto-generated method stub
        return bizdao.getSmbmsBillIspay();
    }

}
