/**
 * Project Name:jsp180419
 * File Name:Tokenutil.java
 * Package Name:util
 * Date:2018年4月22日上午11:13:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package util;

import java.util.UUID;

/**
 * Description: <br/>
 * Date: 2018年4月22日 上午11:13:27 <br/>
 * 
 * @author lvwei
 * @version
 * @see
 */

// 单例模式 提供什么功能的方法
public class TokenUtil {
    // 不让其它类创建此类对象
    private TokenUtil() {
    }

    // 在奔雷创建本类对象
    static TokenUtil tu = null;

    public static TokenUtil getInstance() {
        if (tu == null) {
            tu = new TokenUtil();
        }
        return tu;
    }

    // uuid:创建令牌
    public static String get_token() {
        return UUID.randomUUID().toString();
    }
}
