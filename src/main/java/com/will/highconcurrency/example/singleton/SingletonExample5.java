package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 懒汉模式:第一次使用的时候才会创建对象
 */
@ThreadSafe
public class SingletonExample5 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     */
    private SingletonExample5() {

    }

    //单例对象
    private volatile static SingletonExample5 instance = null;

    /**
     * 静态工厂方法
     * 在上一个例子中我们知道
     * 因为当执行new SingletonExample4()的时候会发生一下情况
     * 1. memory = allocate() 分配对象的内存空间
     * 2. ctorInstance() 初始化对象
     * 3. instance = memory 设置instance指向刚分配的内存
     * 以上三步在单线程的情况下是没有问题的
     * 但是在多线程的情况下, JVM和CPU优化的时候, 我们知道会出现"指令重排", 那么这个时候问题出现了
     * 在多线程情况下, 比如说经过指令重排后, 执行顺序变成了以下情况
     * 1. memory = allocate() 分配对象的内存空间
     * 3. instance = memory 设置instance指向刚分配的内存
     * 2. ctorInstance() 初始化对象
     *
     * 经过指令重排后, 上个例子已经说明了会出现什么样的线程问题
     * 那么这时候我们可以加上volatile关键字(禁止指令重排)
     * private volatile static SingletonExample5 instance = null;
     * 那么就可以解决这个问题
     * 注意:这个问题在日常工作中是非常难发现的, 所以必须格外小心
     * @return
     */
    public static SingletonExample5 getInstance() {
        //使用了双重检测机制
        if(instance == null){
            //使用synchronized锁定代码块, 而不是整个方法
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
