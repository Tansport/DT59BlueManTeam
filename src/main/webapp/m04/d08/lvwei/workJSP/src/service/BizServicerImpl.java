/**
 * Project Name:workJSP
 * File Name:BizServicerImpl.java
 * Package Name:service
 * Date:2018年4月4日上午12:33:38
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package service;

import java.util.List;

import dao.BizDao;
import entity.NewsInfo;
import entity.UserInfo;
import entity.comment_info;

/**
 * Description: <br/>
 * Date: 2018年4月4日 上午12:33:38 <br/>
 * 
 * @author lvwei
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

    @Override
    public int delNewsInfoById(int id) {

        // Auto-generated method stub
        return bizdao.delNewsInfoById(id);
    }

    @Override
    public int gengxin(NewsInfo nf) {

        // Auto-generated method stub
        return bizdao.gengxin(nf);
    }

    @Override
    public List<comment_info> all1() {

        // Auto-generated method stub
        return bizdao.all1();
    }
}
