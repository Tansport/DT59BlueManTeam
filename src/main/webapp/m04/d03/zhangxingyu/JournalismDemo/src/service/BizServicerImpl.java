/**
 * Project Name:Jsp
 * File Name:BizServicerImpl.java
 * Package Name:service
 * Date:2018年4月6日下午9:56:51
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package service;

import java.util.List;

import dao.BizDao;
import entity.NewsInfo;
import entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018年4月6日 下午9:56:51 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class BizServicerImpl {

    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    public boolean denglu(UserInfo user) {

        // Auto-generated method stub
        return bizdao.denglu(user);
    }

    public List<NewsInfo> all() {

        // Auto-generated method stub
        return bizdao.all();
    }

}