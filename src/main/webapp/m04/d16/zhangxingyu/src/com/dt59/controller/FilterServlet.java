/**
 * Project Name:Demo_dt59_pinHong_01
 * File Name:FilterServlet.java
 * Package Name:com.dt59.controller
 * Date:2018年4月16日下午1:55:49
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午1:55:49 <br/>
 * 
 * @author zhangxingyu
 * @version
 * @see
 */
public class FilterServlet implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        arg2.doFilter(arg0, arg1);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
