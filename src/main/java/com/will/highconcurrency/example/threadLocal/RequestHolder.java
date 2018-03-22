package com.will.highconcurrency.example.threadLocal;

/**
 * Created by Will.Zhang on 2018/3/22 0022 15:05.
 * ThreadLocal的使用案例
 * 模拟登录取出当前用户
 */
public class RequestHolder {

    /**
     * 存储用户id(也可以是整个用户对象)
     * 通常用户登录信息是存储在request中, 如果把request不断往下传, 只是单纯为了获取用户信息, 这样会造成代码非常难看
     * 这里模拟使用ThreadLocal来存储用户的id,
     * 使用filter拦截请求, 并且把用户id存储到ThreadLocal中
     * 在需要用的时候调用RequestHolder.getId, 马上就能获取到用户id了
     *
     * ThreadLocal低层是用map来实现的, key是当前线程的id, value就是我们指定的用户id
     * 只要是当前线程, 无论在哪里都能轻松获取到用户的信息
     */
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 最后需要把用户id  remove掉
     * 否则有内存溢出的风险
     */
    public static void remove(){
        requestHolder.remove();
    }


}
