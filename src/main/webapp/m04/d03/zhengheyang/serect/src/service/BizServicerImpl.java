/**
 * Project Name:workJSP
 * File Name:BizServicerImpl.java
 * Package Name:service
 * Date:2018��4��4������12:33:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package service;

import java.util.List;

import dao.BizDao;
import entity.NewsInfo;
import entity.UserInfo;

/**
 * Description: <br/>
 * Date: 2018��4��4�� ����12:33:38 <br/>
 * 
 * @author zhengheyang
 * @version
 * @see
 */
public class BizServicerImpl implements BizService {

    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public boolean denglu(UserInfo user) {

        // Auto-generated method stub
        return bizdao.denglu(user);
    }

    @Override
    public List<NewsInfo> all() {

        // Auto-generated method stub
        return bizdao.all();
    }

}
