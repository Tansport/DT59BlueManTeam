package com.dt59.java;

import java.util.Scanner;

import com.dt59.dao.BizDao;
import com.dt59.dao.impl.BizDaoImpl;
import com.dt59.entity.Info2;
import com.dt59.util.CastDateUtil;

public class Demo2 {
    // @Test
    public void save() {
        BizDao bizDao = new BizDaoImpl();
        Info2 ff = new Info2();
        Scanner sc = new Scanner(System.in);
        System.out.println("����������");
        ff.setName(sc.next());
        System.out.println("����������:");
        ff.setBirthday(CastDateUtil.getDateFormat(sc.next()));// ���ַ�ת����Date
                                                              // Simpledateformat
        int flag = bizDao.saveInfo2(ff);
        System.out.println("��ӽ��" + flag);
    }

}
