package com.will.highconcurrency;

import com.will.highconcurrency.example.threadLocal.RequestHolder;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Will.Zhang on 2018/3/22 0022 15:42.
 * 一个普通的Interceptor
 * 用于演示com.will.highconcurrency.example.threadLocal.RequestHolder当处理完毕之后, 把当前线程的用户id移除, 预防内存溢出
 */
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        RequestHolder.remove();
        System.out.println("afterCompletion");
        return;
    }
}
