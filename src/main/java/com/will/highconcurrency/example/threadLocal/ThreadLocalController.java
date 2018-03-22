package com.will.highconcurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Will.Zhang on 2018/3/22 0022 15:48.
 * 请求地址 http://localhost:8080/threadLocal/test
 *
 * 请求来的时候HttpFilter会拦截当前请求, 并把当前用户id(当前线程id)放进ThreadLocal里
 * 那么在test方法中就很容易获取当前用户信息(在其他地方也能很容易获取)
 * 业务流程处理完之后HttpInterceptor会把用户信息remove掉
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    /**
     * 模拟获取当前用户登录id
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    public Long test() {
        return RequestHolder.getId();
    }
}
