/**
 * Project Name:shopping
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018��5��17������3:15:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.HashMap;
import java.util.List;

import com.dt59.pojo.Bill;
import com.dt59.pojo.Page;
import com.dt59.pojo.User;

/**
 * Description: <br/>
 * Date: 2018��5��17�� ����3:15:49 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public interface BizDao {
    List<User> validateUser(User us);

    List<Bill> getAllBill();

    List<String> getProviderByTinc();

    List<String> getSmbmsBillIspay();

    int delBillCode(String billCode);

    List<Bill> getAllBillByTj(HashMap<String, Object> map);

    List<Bill> getAllBillByPage(Page pg); // ��ȡҳ��

    int getAllBillCount(); // ������з�ҳ��ѯ������

    Bill getBillById(int id);

    int updateBillById(Bill sb);

    List<User> getAllUser();
}
