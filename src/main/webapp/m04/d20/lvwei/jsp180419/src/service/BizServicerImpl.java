package service;

import java.util.List;

import dao.BizDao;
import entity.shangping;
import entity.shangpingche;

public class BizServicerImpl implements BizService {

    private BizDao bizdao;

    public BizDao getBizdao() {
        return bizdao;
    }

    public void setBizdao(BizDao bizdao) {
        this.bizdao = bizdao;
    }

    @Override
    public List<shangping> getallshangpingList() {

        // Auto-generated method stub
        return bizdao.getallshangpingList();
    }

    @Override
    public boolean User(String name, String upwd) {

        // Auto-generated method stub
        return bizdao.User(name, upwd);
    }

    @Override
    public shangping getshagshangpin(int spid) {

        // Auto-generated method stub
        return bizdao.getshagshangpin(spid);
    }

    @Override
    public int setche(shangpingche che) {

        // Auto-generated method stub
        return bizdao.setche(che);
    }

}
