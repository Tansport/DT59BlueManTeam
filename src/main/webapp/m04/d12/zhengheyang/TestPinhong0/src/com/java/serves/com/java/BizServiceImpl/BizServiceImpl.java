package com.java.serves.com.java.BizServiceImpl;

import com.java.dao.Bizdao;
import com.java.entity.News;
import com.java.serves.BizService;

import java.util.List;

public class BizServiceImpl implements BizService {
    private Bizdao bizdao;

    public Bizdao getBizdao() {
        return bizdao;
    }

    public void setBizdao(Bizdao bizdao) {
        this.bizdao = bizdao;
    }

    public List<News> getAllNews() {
        return bizdao.getAllNews();
    }
}
