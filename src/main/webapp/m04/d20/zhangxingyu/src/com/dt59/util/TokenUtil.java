package com.dt59.util;

import java.util.UUID;

//����ģʽ�ṩʲô���ܵķ�����
public class TokenUtil {
    // �����������򴴽��������
    private TokenUtil() {
    }

    // �ڱ����д���һ���������
    static TokenUtil tu = null;

    // �����ṩ������ �����������ȡ�������
    public static TokenUtil getInstance() {
        if (tu == null) {
            tu = new TokenUtil();
        }
        return tu;
    }

    // uuid ��������
    public synchronized String get_token() {
        return UUID.randomUUID().toString();
    }
}
