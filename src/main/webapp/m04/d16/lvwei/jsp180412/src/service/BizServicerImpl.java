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
import entity.Message;
import entity.News;
import entity.Page;
import entity.Product;
import entity.User;
import entity.revert;

/**
 * Description: <br/>
 * Date: 2018年4月4日 上午12:33:38 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */
public class BizServicerImpl implements BizService {

    @Override
    public List<User> getAllUser() {

        // Auto-generated method stub
        return bizdao.getAllUser();
    }

    @Override
    public List<Product> getALLProduct() {

        // Auto-generated method stub
        return bizdao.getALLProduct();
    }

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
    public boolean validateUser(User user) {

        // Auto-generated method stub
        return bizdao.validateUser(user);
    }

    @Override
    public String AllUser(User user) {

        // Auto-generated method stub
        return bizdao.AllUser(user);
    }

    @Override
    public List<Page> sum() {

        // Auto-generated method stub
        return bizdao.sum();
    }

    @Override
    public List<Product> newslist(Page page) {

        // Auto-generated method stub
        return bizdao.newslist(page);
    }

    @Override
    public List<Message> getmessage() {

        // Auto-generated method stub
        return bizdao.getmessage();
    }

    @Override
    public List<revert> getrevert() {

        // Auto-generated method stub
        return bizdao.getrevert();
    }

    @Override
    public int setrevert(int mid, String rcontent, String rname) {

        // Auto-generated method stub
        return bizdao.setrevert(mid, rcontent, rname);
    }

}
