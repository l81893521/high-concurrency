package com.will.highconcurrency;

import com.will.highconcurrency.example.threadLocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Will.Zhang on 2018/3/22 0022 15:09.
 * 一个普通的filter
 * 用于演示com.will.highconcurrency.example.threadLocal.RequestHolder使用filter拦截请求并把值存储到RequestHolder中
 */
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("do filter, current Thread id=" + Thread.currentThread().getId() + ", path=" + request.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
