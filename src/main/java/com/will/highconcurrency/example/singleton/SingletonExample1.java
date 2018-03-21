package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.NotThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 懒汉模式:第一次使用的时候才会创建对象
 */
@NotThreadSafe
public class SingletonExample1 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     */
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 instance = null;

    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample1 getInstance() {
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
