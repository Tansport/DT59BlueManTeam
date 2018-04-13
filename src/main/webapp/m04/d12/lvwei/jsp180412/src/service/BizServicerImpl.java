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
import entity.News;
import entity.Product;

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

}
