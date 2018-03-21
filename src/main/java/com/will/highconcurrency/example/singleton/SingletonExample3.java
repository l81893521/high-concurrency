package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.NotRecommand;
import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 懒汉模式:第一次使用的时候才会创建对象
 */
@ThreadSafe
@NotRecommand
public class SingletonExample3 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     */
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 instance = null;

    /**
     * 静态工厂方法
     * 在添加了synchronized之后
     * 能够保证线程安全
     * 但是这种写法是不推荐的, 因为synchronized会导致比较高的性能开销
     * @return
     */
    public static synchronized SingletonExample3 getInstance() {
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
