package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 饿汉模式:类装载的时候就创建对象(能够保证线程安全)
 */
@ThreadSafe
public class SingletonExample2 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     * 饿汉模式的缺点是如果类的初始化内容过多
     * 可能会导致时间过长的问题
     * 而且如果类没有被真正调用, 可能会造成资源浪费
     */
    private SingletonExample2() {

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
