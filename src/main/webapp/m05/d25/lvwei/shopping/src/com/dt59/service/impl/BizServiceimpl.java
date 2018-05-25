/**
 * Project Name:shopping
 * File Name:BizServiceimpl.java
 * Package Name:com.dt59.service.impl
 * Date:2018年5月17日下午4:50:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.service.impl;

import java.util.HashMap;
import java.util.List;

import com.dt59.dao.BizDao;
import com.dt59.pojo.Bill;
import com.dt59.pojo.Page;
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

    @Override
    public int delBillCode(String billCode) {

        // Auto-generated method stub
        return bizdao.delBillCode(billCode);
    }

    @Override
    public List<Bill> getAllBillByTj(HashMap<String, Object> map) {

        // Auto-generated method stub
        return bizdao.getAllBillByTj(map);
    }

    @Override
    public List<Bill> getAllBillByPage(Page pg) {

        // Auto-generated method stub
        return bizdao.getAllBillByPage(pg);
    }

    @Override
    public int getAllBillCount() {

        // Auto-generated method stub
        return bizdao.getAllBillCount();
    }

    @Override
    public Bill getBillById(int id) {

        // Auto-generated method stub
        return bizdao.getBillById(id);
    }

    @Override
    public int updateBillById(Bill sb) {

        // Auto-generated method stub
        return bizdao.updateBillById(sb);
    }

    @Override
    public List<User> getAllUser() {

        // Auto-generated method stub
        return bizdao.getAllUser();
    }

}
