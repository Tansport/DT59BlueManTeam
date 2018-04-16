/**
 * Project Name:Demo_dt59_pinhong_01
 * File Name:BizDao.java
 * Package Name:com.dt59.dao
 * Date:2018年4月12日下午6:56:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.dao;

import java.util.List;

import com.dt59.entity.Message;
import com.dt59.entity.News;
import com.dt59.entity.Page;
import com.dt59.entity.Product;
import com.dt59.entity.Revert;
import com.dt59.entity.User;
/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午6:56:39 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
    List<News> getAllNews();
    
    List<Product> getAllProduct();
    
    boolean validateUser(User user);
     
    List<User> getAllUser();
    
    String validate(User user);
    
    List<Product> getAllProductByPage(Page page);
    
    int getProductNumber();
    
    List<Message> getAllMessage();
    
    List<Revert> getAllRevert();
    
//    int setrevert(int mid, String rcontent, String rname);

}

