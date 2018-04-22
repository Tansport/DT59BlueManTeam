/**
 * Project Name:Demo_dt59_shopping
 * File Name:Token.java
 * Package Name:com.dt59.until
 * Date:2018年4月22日下午1:28:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.until;

import java.util.UUID;

/**
 * Description: <br/>
 * Date: 2018年4月22日 下午1:28:22 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class Token {
    private static Token token = null;// 定义私有静态属性

    private Token() {// 定义私有构造方法
    }

    public static Token getInstance() {// 对外提供方法，让其他程序获取对象
        if (token == null) {
            token = new Token();
        }
        return token;
    }

    public synchronized String get_token() {// 创建令牌，思考：如何保证多个访问者中，方法的安全性
        return UUID.randomUUID().toString();
    }

}
