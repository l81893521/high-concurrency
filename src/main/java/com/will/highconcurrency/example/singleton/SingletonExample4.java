package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.NotRecommand;
import com.will.highconcurrency.annoations.NotThreadSafe;
import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 懒汉模式:第一次使用的时候才会创建对象
 */
@NotThreadSafe
public class SingletonExample4 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     */
    private SingletonExample4() {

    }

    //单例对象
    private static SingletonExample4 instance = null;

    /**
     * 静态工厂方法
     * 但是这种写法还是线程不安全的
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
     * A线程执行到instance = new SingletonExample4();
     * 并且已经执行了1和3两步, 但是第2步(初始化对象)还没执行
     * 同时
     * B线程执行到了第一个判断if(instance == null)
     * B线程发现instance已经不等于null了, 并且将instance返回
     * 那么问题显然意见, 这时候返回的instance是没有初始化完成的
     * @return
     */
    public static SingletonExample4 getInstance() {
        //使用了双重检测机制
        if(instance == null){
            //使用synchronized锁定代码块, 而不是整个方法
            //但是它还是线程不安全的
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
