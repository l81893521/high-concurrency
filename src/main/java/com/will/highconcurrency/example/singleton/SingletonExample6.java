package com.will.highconcurrency.example.singleton;

import com.will.highconcurrency.annoations.ThreadSafe;

/**
 * Created by Will.Zhang on 2018/3/21 0021 15:31.
 * 单例模式
 * 饿汉模式:类装载的时候就创建对象(能够保证线程安全)
 */
@ThreadSafe
public class SingletonExample6 {

    /**
     * 私有构造函数
     * 不能通过new创造实例
     * 饿汉模式的缺点是如果类的初始化内容过多
     * 可能会导致时间过长的问题
     * 而且如果类没有被真正调用, 可能会造成资源浪费
     */
    private SingletonExample6() {

    }

    /*
    这里有一个特别需要注意的问题就是, 静态块和静态变量的执行顺序
    如果代码顺序写成
    static {
        instance = new SingletonExample6();
    }
    private static SingletonExample6 instance = null;
    那么main方法得到的是null, 为什么呢
    因为会先执行静态域的
    instance = new SingletonExample6();
    然后再执行
    private static SingletonExample6 instance = null;
    这时候instance又重新被复制成null
    这里可以加断点调试一下, 以便更清晰看到执行顺序

    那么把代码改写成
    private static SingletonExample6 instance = null;
    static {
        instance = new SingletonExample6();
    }

    main方法就能得到正确的结果

     */

    //单例对象
    private static SingletonExample6 instance = null;

    /**
     * 还可以通过静态块来初始化
     */
    static {
        instance = new SingletonExample6();
    }




    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
